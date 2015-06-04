package by.bsuir.model.logic;


import by.bsuir.model.DAO.ReservationDAO;
import by.bsuir.model.domain.Reservation;

public class ReservationLogic {

    public boolean createReservation(Reservation reservation){
        boolean flag = false;
        ReservationDAO dao = new ReservationDAO();
        if(dao.insertReservation(reservation)){
            flag = true;
        }
        return flag;
    }

    public boolean addCheck(int orderId){
        boolean flag = false;
        ReservationDAO dao = new ReservationDAO();
        if(dao.insertCheck(orderId)){
            flag = true;
        }
        return flag;
    }
}
