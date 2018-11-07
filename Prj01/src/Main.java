import exceptions.IlluminanceTooLessException;
import exceptions.IlluminanceTooMuchException;
import exceptions.SpaceUsageTooMaxException;
import furniture.FurnitureObject;
import light.LightBulb;

/**
 * @author OK
 * @since 22.10.2018
 */
class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();

        Building building = new Building();
        building.addRoom(234, new Room("Living room", 100, 2));
        building.addRoom(189, new Room("Office room", 50, 20));

        building.getRoom(234).add(new LightBulb(100));
        building.getRoom(234).add(new LightBulb(100));
        building.getRoom(234).add(new FurnitureObject("Table", 9));
        building.getRoom(234).add(new FurnitureObject("Sofa", 3, 5));

        building.describe();

        try {
            validator.validate(building.getRoom(189));//
        } catch (IlluminanceTooMuchException | IlluminanceTooLessException | SpaceUsageTooMaxException a){
            System.out.println(a.getMessage());
        }
    }
}
