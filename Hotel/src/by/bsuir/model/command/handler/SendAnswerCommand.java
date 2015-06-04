package by.bsuir.model.command.handler;

import by.bsuir.model.command.configuration.ConfigurationManager;
import by.bsuir.model.domain.Reservation;
import by.bsuir.model.logic.ReservationLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SendAnswerCommand implements ActionCommand {
    private static Logger log = Logger.getLogger(SendAnswerCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        Reservation reservation = new Reservation(Integer.parseInt(request.getParameter("room")),
                String.valueOf(session.getAttribute("login")),
                Integer.parseInt(request.getParameter("orderId")));
        ReservationLogic reservationLogic = new ReservationLogic();
        if(reservationLogic.createReservation(reservation)){
            reservationLogic.addCheck(reservation.getOrderId());
            request.setAttribute("message", "Check sent successfully");
            page = ConfigurationManager.getProperty("path.page.admin-main");
        }
        return page;
    }
}
