import furniture.FurnitureObject;
import light.LightBulb;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author OK
 * @since 22.10.2018
 */
public class Room extends Building{
    private final int WINDOW_ILLUMINANCE = 700;

    private final String roomName;
    private final double roomSquare;
    private int amountOfWindows = 0;

    private int roomIlluminance;

    private int occupiedSquareMin;
    private int occupiedSquareMax;

    private final ArrayList<LightBulb> bulbs = new ArrayList<>();
    private final ArrayList<FurnitureObject> allFurniture = new ArrayList<>();


    public Room(String roomName, double roomSquare, int amountOfWindows) {
        if (amountOfWindows < 0){
            throw new IllegalArgumentException("amount of windows can't be less than 0");
        } else {
            this.roomSquare = roomSquare;
            this.amountOfWindows = amountOfWindows;
            this.roomName = roomName;
            roomIlluminance = WINDOW_ILLUMINANCE * amountOfWindows;
        }
    }

    public Room(String roomName, double roomSquare) {
        this.roomName = roomName;
        this.roomSquare = roomSquare;
    }

    /**
     * Add new lightBulb to room.
     * @param bulb
     */
    public void add(LightBulb bulb){
        roomIlluminance += bulb.getIlluminance();
        bulbs.add(bulb);
    }

    /**
     * Add new furniture to room.
     * @param furniture
     */
    public void add(FurnitureObject furniture){
        allFurniture.add(furniture);
        occupiedSquareMax += furniture.getFurnitureSquare();
        if (furniture.getFurnitureSquareMin() == furniture.getFurnitureSquare()){
            occupiedSquareMin += furniture.getFurnitureSquare();
        } else {
            occupiedSquareMin += furniture.getFurnitureSquareMin();
        }

    }


    public double getRoomSquare() {
        return roomSquare;
    }

    public int getOccupiedSquareMax() {
        return occupiedSquareMax;
    }

    public int getRoomIlluminance() {
        return roomIlluminance;
    }

    @Override
    public String toString() {
        return roomName +
                "\n illuminance = " + roomIlluminance + " (" + amountOfWindows + " window with " + WINDOW_ILLUMINANCE +
                " each, bulbs:" + bulbs +

                "\n square = " + roomSquare + "m^2 (occupied " + occupiedSquareMin + "-" + occupiedSquareMax +
                "m^2, guarantee free " + (roomSquare - occupiedSquareMax) + "m^2 or " + (100 -((occupiedSquareMax/roomSquare)*100)) +
                "% of all square)" +

                "\n furniture: " + allFurniture;
    }
}
