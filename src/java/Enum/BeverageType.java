package Enum;

public enum BeverageType {
    water {
        @Override
        public String toString() {
            return "წყალი";
        } 
    }
   , wine {
        @Override
        public String toString() {
            return "ღვინო";
        }
    }
   , soda{
       @Override
        public String toString() {
            return "გაზიანი სასმელი";
        }
       
   }
   ,test
}
