package Enum;

public enum QuantityType {
    by_weight {
        @Override
        public String toString() {
            return "კილოგრამი";
        }
    }, by_retail {
        @Override
        public String toString() {
            return "ცალი";
        }
    }
}
