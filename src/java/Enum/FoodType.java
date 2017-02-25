package Enum;

public enum FoodType {
    Food {
        @Override
        public String toString() {
            return "საჭმელი";
        } 
    }
   , Beverage {
        @Override
        public String toString() {
            return "სასმელი";
        }
    }
}
