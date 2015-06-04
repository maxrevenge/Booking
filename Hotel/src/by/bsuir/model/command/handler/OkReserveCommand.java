package by.bsuir.model.command.handler;


import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.logic.OrderLogic;
import by.bsuir.model.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class OkReserveCommand implements ActionCommand {
  
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int guests = Integer.parseInt(request.getParameter("guests"));
        String departureDate = request.getParameter("departure");
        String arrivalDate = request.getParameter("arrival");
        String login = String.valueOf(session.getAttribute("login"));

        int price = Integer.parseInt(request.getParameter("room_price"));
        boolean flag = true;

        Validator validator = new Validator();
        OrderLogic orderLogic = new OrderLogic();
        if(validator.orderIsValid(price, guests,arrivalDate, departureDate, login)){
            if(!orderLogic.createOrder(guests, arrivalDate, departureDate, login, price)){
                request.setAttribute("message", "Error in ordering");
                request.setAttribute("price", 0);
            } else {
                long orderPrice = orderLogic.calculateOrderPrice(arrivalDate, departureDate, price);
                request.setAttribute("price", orderPrice);
                request.setAttribute("message", "Order sent successfully");
            }
        } else{
            request.setAttribute("message", "Error in ordering");
        }
       
        return ConfigurationManager.getProperty("path.page.main");

    }

}

