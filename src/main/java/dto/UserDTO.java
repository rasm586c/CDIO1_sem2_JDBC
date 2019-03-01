package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dal.IUserDAO;
import utils.*;

public class UserDTO implements Serializable{
    private int	userId;
    private String userName;
    private String ini;
    private String password;
    private String cpr;
    private List<String> roles;
    private InputVerifier verifier;

    public UserDTO() {
        verifier = new InputVerifier();
        this.roles = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) throws IUserDAO.DALException {
        if (verifier.verifyUsername(userName)) {
            this.userName = userName;
        } else {
            throw new IUserDAO.DALException("Username does not meet the requirements!");
        }
    }
    public String getIni() {
        return ini;
    }
    public void setIni(String ini) throws IUserDAO.DALException {
        if (verifier.verifyInitials(ini)) {
            this.ini = ini;
        } else {
            throw new IUserDAO.DALException("Initials does not meet the requirements!");
        }
    }

    public String getPassword() { return password; }
    public void setPassword(String password) throws IUserDAO.DALException
    {
        if (verifier.verifyPassword(password)) {
            this.password = password;
        } else {
            throw new IUserDAO.DALException("Password does not meet the requirements!");
        }
    }

    public String getCpr() { return cpr; }
    public void setCpr(String cpr) { this.cpr = cpr; }

    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role){
        this.roles.add(role);
    }
    /**
     *
     * @param role
     * @return true if role existed, false if not
     */
    public boolean removeRole(String role){
        return this.roles.remove(role);
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
    }



}
