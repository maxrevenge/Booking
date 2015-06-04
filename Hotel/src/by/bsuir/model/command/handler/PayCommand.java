package by.bsuir.model.command.handler;

import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.logic.CheckLogic;

import javax.servlet.http.HttpServletRequest;


public class PayCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int price = Integer.parseInt(request.getParameter("price"));
        String login = request.getParameter("login");
        int checkId = Integer.parseInt(request.getParameter("check_id"));
        CheckLogic checkLogic = new CheckLogic();
        if(checkLogic.payCheck(login, price, checkId)){
            request.setAttribute("message", "Successfully payed");
        }
        else{
            request.setAttribute("message","Error in pay process");
        }
        page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}
