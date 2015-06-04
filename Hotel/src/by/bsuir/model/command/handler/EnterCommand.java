package by.bsuir.model.command.handler;

import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.logic.OrderLogic;
import by.bsuir.model.logic.UserLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class EnterCommand implements ActionCommand {
   
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
      
        if(ConfigurationManager.getProperty("admin.username").equals(username) &&
                ConfigurationManager.getProperty("admin.password").equals(password)){
            OrderLogic orderLogic = new OrderLogic();
            if(orderLogic.selectOrders() == null){
                request.setAttribute("errorMessage", "No new orders");
            } else{
                request.setAttribute("orders", orderLogic.selectOrders());
                request.setAttribute("old_orders", orderLogic.selectOldOrders());
            }
            page = ConfigurationManager.getProperty("path.page.admin-main");
            session.setAttribute("login", username);
           
        } else {
            session.setAttribute("login", username);
            UserLogic userLogic = new UserLogic();
            if (userLogic.checkUser(username, password)) {
                page = ConfigurationManager.getProperty("path.page.main");

            } else {
                request.setAttribute("errorMessage", "Error entering system");
                page = ConfigurationManager.getProperty("path.page.login");
            }
        }
        return page;
    }
}
