package Servlet;

import Dao.FoodDAO;
import Dao.FoodDAOImpl;
import Enum.FoodType;
import Enum.QuantityType;
import Model.Food;
import Model.Ingredient;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Relay")
@MultipartConfig
public class addFoodServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 5000 * 1024;
    private int maxMemSize = 5000 * 1024;
    private File file;

    public void init() {
        // Get the file location where it would be stored.
        filePath
                = getServletContext().getInitParameter("file-upload");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String fname = request.getParameter("name");
            String ftype = request.getParameter("type");
            FoodType type = FoodType.valueOf(ftype);
            String cookingWay = request.getParameter("cookingway");
            String quantity1 = request.getParameter("quantity");
            int quantity = Integer.parseInt(quantity1);
            ArrayList<Ingredient> ins = new ArrayList<>();
            Ingredient in = null;
            
            for (int i = 1; i < quantity + 1; i++) {
                
                String iname = request.getParameter("name_" + i);
                String iquantitystr = request.getParameter("quantity_" + i);
                int iquantity = Integer.parseInt(iquantitystr);
                String itype = request.getParameter("type_" + i);
                String icomment = request.getParameter("comment_" + i);
                
                QuantityType intype = QuantityType.valueOf(itype);
                
                in = new Ingredient(iname, iquantity, intype, icomment);
                ins.add(in);
                
                if (fname.isEmpty() || cookingWay.isEmpty()) {
                    request.setAttribute("addFoodFailed", true);
                    RequestDispatcher rd = request.getRequestDispatcher("addfood.jsp");
                    rd.forward(request, response);
                } else {
                    Food d = new Food(ins, fname, type, cookingWay);
                    FoodDAO dao = new FoodDAOImpl();
                    dao.addFood(d);
                }
            }
            
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("c:\\temp"));
            
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);
            
            
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    try {
                        fi.write(file);
                    } catch (Exception ex) {
                        Logger.getLogger(addFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(addFoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

}
