import java.util.*;

/**
 * @author OK
 * @since 07.11.2018
 */
public class Building {
    private Map<Integer, Room> rooms = new TreeMap<>();

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public void addRoom(Integer roomNumber, Room room){
        rooms.put(roomNumber, room);
    }

    public Room getRoom(Integer roomNumber) {
        if (rooms.get(roomNumber) == null){
            System.out.println("This room doesn't exist");
        }
        return rooms.get(roomNumber);
    }

    public void describe(){
        for (Map.Entry <Integer, Room> entry : rooms.entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
