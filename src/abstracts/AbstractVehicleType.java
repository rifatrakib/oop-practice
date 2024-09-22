package abstracts;

import interfaces.CategoryInterface;

public class AbstractVehicleType implements CategoryInterface {
    private final String type;

    public AbstractVehicleType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
