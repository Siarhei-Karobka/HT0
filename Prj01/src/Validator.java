import exceptions.IlluminanceTooLessException;
import exceptions.IlluminanceTooMuchException;
import exceptions.SpaceUsageTooMaxException;

import java.util.Map;

/**
 * @author OK
 * @since 31.10.2018
 */
public class Validator {
    private final int MIN_ILLUMINANCE = 300;
    private final int MAX_ILLUMINANCE = 4000;
    private final double MAX_OCCUPIED_SQUARE_DELTA = 0.7;

    public void validate (Room room) throws IlluminanceTooLessException, IlluminanceTooMuchException, SpaceUsageTooMaxException{

            if (room.getRoomIlluminance() < MIN_ILLUMINANCE){
                throw new IlluminanceTooLessException("Illuminance should be more than " + MIN_ILLUMINANCE + "lm");
            } else if (room.getRoomIlluminance() > MAX_ILLUMINANCE){
                throw new IlluminanceTooMuchException("Illuminance shouldn't be more than " + MAX_ILLUMINANCE + "lm");
            } else if ((room.getOccupiedSquareMax()/room.getRoomSquare()) > MAX_OCCUPIED_SQUARE_DELTA){
                throw new SpaceUsageTooMaxException("Occupied square shouldn't be more than " +
                        (MAX_OCCUPIED_SQUARE_DELTA * 100) + "% of all room square");
            }
        }
    }

//    public void validate (Building building) throws IlluminanceTooLessException, IlluminanceTooMuchException, SpaceUsageTooMaxException{
//
//        for (Map.Entry <Integer, Room> room : building.getRooms().entrySet()) {
//            if (room.getValue().getRoomIlluminance() < MIN_ILLUMINANCE){
//                throw new IlluminanceTooLessException("Illuminance should be more than " + MIN_ILLUMINANCE + "lm");
//            } else if (room.getValue().getRoomIlluminance() > MAX_ILLUMINANCE){
//                throw new IlluminanceTooMuchException("Illuminance shouldn't be more than " + MAX_ILLUMINANCE + "lm");
//            } else if ((room.getValue().getOccupiedSquareMax()/room.getValue().getRoomSquare()) > MAX_OCCUPIED_SQUARE_DELTA){
//                throw new SpaceUsageTooMaxException("Occupied square shouldn't be more than " +
//                        (MAX_OCCUPIED_SQUARE_DELTA * 100) + "% of all room square");
//            }
//        }
//    }

