package Enum;

public enum Gender {
    male {
        @Override
        public String toString() {
            return "მამრობითი";
        }
    }, female {
        @Override
        public String toString() {
            return "მდედრობითი";
        }
    };
      
    
    public static String getGenderValue(String s) {
        String s1 = null;
       for(Gender g : values()){
          if(s.equals(g.toString()))
           s1 = g.name();
       }
        return s1;
        
        
    }
}
