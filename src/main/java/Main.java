import GUI.TUI;
import dal.IUserDAO;
import dal.UserDAO;
import dto.UserDTO;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            TUI tui = new TUI();
            while (tui.showMenu()) {}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}