package by.bsuir.model.command.handler.navigation;

import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.command.handler.ActionCommand;
import by.bsuir.model.logic.CheckLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class GoToOrdersCommand implements ActionCommand {
  
    @Override
    public String execute(HttpServletRequest request) {
        CheckLogic checkLogic = new CheckLogic();
        HttpSession session = request.getSession();
        String login = String.valueOf(session.getAttribute("login"));

        request.setAttribute("checks", checkLogic.getChecks(login));
        return ConfigurationManager.getProperty("path.page.orders");
    }
}
