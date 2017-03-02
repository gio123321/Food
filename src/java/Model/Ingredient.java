
package Model;

import Enum.QuantityType;

public class Ingredient {
    
    private int id;

    
    private String name;
    
    private double quantity;
    
    private QuantityType type; 
            
    private String comment;

    public Ingredient() {
    }

    public Ingredient(String name, double quantity, QuantityType type, String comment) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public QuantityType getType() {
        return type;
    }

    public void setType(QuantityType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
