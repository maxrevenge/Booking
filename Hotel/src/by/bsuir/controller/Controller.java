package by.bsuir.controller;

import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.command.factory.ActionFactory;
import by.bsuir.model.command.handler.ActionCommand;
import by.bsuir.model.pool.ConnectionPool;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static Logger log = Logger.getLogger(Controller.class);

    @Override
    public void init() throws ServletException {

        ConnectionPool pool;
        String prefix = getServletContext().getRealPath("/");
        String filename = getInitParameter("logFileName");
        if (filename != null) {
            PropertyConfigurator.configure(prefix + filename);
        }
        pool = ConnectionPool.getInstance();
        log.info("Init Controller");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String page;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);

            dispatcher.forward(request, response);
        }
        else {
            log.warn("Null page returned");
            response.sendRedirect(ConfigurationManager.getProperty("path.page.index"));
        }

    }

}
