package by.bsuir.model.command.handler.navigation;


import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.command.handler.ActionCommand;
import by.bsuir.model.domain.Room;
import by.bsuir.model.logic.RoomLogic;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class GoToRoomsCommand implements ActionCommand{
    @Override
   
    public String execute(HttpServletRequest request) {
        String page = null;
        RoomLogic roomLogic = new RoomLogic();
        ArrayList<Room> rooms = new ArrayList<>();
        rooms = roomLogic.getRoomTypes();
        if(rooms != null){
            request.setAttribute("rooms", rooms);
        }
        return ConfigurationManager.getProperty("path.page.rooms");
    }
}
