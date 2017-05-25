package Enum;

public enum BeverageType {
    wather {
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
}
