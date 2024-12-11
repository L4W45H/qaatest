package eNums;

public enum Endpoints {
    USERS("/users"),
    POSTS("/posts");

    public final String label;

    private Endpoints(String label) {
        this.label = label;
    }
    public static String valueOfLabel(Endpoints label) {
        for (Endpoints e : values()) {
            if (e.equals(label)) {
                return e.label;
            }
        }
        return null;
    }
}
