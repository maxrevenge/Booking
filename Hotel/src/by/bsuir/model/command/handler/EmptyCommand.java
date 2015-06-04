package by.bsuir.model.command.handler;





import by.bsuir.model.command.configuration.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    @Override
    /**
     * In the event of an error or a
     * direct appeal to the controller
     * works diversion to the index.jsp page
     */
    public String execute(HttpServletRequest request) {

        String page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
