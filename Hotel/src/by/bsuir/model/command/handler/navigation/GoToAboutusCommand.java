package by.bsuir.model.command.handler.navigation;

import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.command.handler.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class GoToAboutusCommand implements ActionCommand {
    @Override
  
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.aboutus");
    }
}
