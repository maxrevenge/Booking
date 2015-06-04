package by.bsuir.model.logic;


import by.bsuir.model.DAO.UserDAO;
import by.bsuir.model.domain.User;

public class UserLogic {

    private UserDAO userDAO;

    public UserLogic() {
        this.userDAO = new UserDAO();
    }

    public boolean createUser(String login, String password, String email, int account, String role){
        boolean flag = false;
        User user = new User(password, login, account, email, role);
        if(userDAO.insertUser(user)){
            flag = true;
        }
        return flag;
    }

    public boolean checkUser(String username, String password){
        boolean flag = false;
        if(userDAO.findUser(username, password)){
            flag = true;
        }
        return flag;
    }
}
