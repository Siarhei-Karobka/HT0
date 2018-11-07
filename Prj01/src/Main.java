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

        Room room1 = new Room("Living room", 100, 2);

        room1.add(new LightBulb(100));
        room1.add(new LightBulb(100));
        room1.add(new FurnitureObject("Table", 9));
        room1.add(new FurnitureObject("Sofa", 3, 5));

        try {
            validator.validate(room1);
        } catch (IlluminanceTooMuchException | IlluminanceTooLessException | SpaceUsageTooMaxException a){
            System.out.println(a.getMessage());
        }

        System.out.println(room1);
    }
}
