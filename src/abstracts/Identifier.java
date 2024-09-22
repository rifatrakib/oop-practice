package abstracts;

public abstract class Identifier {
    private final String id;

    public Identifier() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }
}
