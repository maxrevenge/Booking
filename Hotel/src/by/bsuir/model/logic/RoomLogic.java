package by.bsuir.model.logic;


import by.bsuir.model.DAO.RoomDAO;
import by.bsuir.model.domain.Room;

import java.util.ArrayList;


public class RoomLogic {
 
    public ArrayList<Room> getRoomTypes(){
        ArrayList<Room> rooms = new ArrayList<>();
        RoomDAO roomDAO = new RoomDAO();
        rooms = roomDAO.selectRoomTypes();
        return rooms;
    }
}
