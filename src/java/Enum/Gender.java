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
}
