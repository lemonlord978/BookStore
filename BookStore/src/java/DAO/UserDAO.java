package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.User;

public class UserDAO extends MyDAO {

    public List<User> getAllUser(){
        List<User> t = new ArrayList<>();
        xSql = "select * from userInfo";
        try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId, xRollno;
            String xName, xusername, xpassword;
            User x;
            while(rs.next()){
                xId = rs.getInt("userID");
                xName = rs.getString("name");
                xusername = rs.getString("username");
                xpassword = rs.getString("password");
                xRollno = rs.getInt("Rollno");
                x = new User(xId,xName,xusername,xpassword,xRollno);
                t.add(x);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return t;
    }
 
//    bằng username và password được nhập vào sẽ tìm ra được record có cùng username và password trong bảng userInfo 
    public User getUser(String xUsername, String xPassword) {
        xSql = "select * from userInfo where username = ? and password = ?";

        int xRollNO, xUserID;
        String xName;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUsername);
            ps.setString(2, xPassword);
            rs = ps.executeQuery();

            if (rs.next()) {
                xUserID = rs.getInt("userID");
                xRollNO = rs.getInt("Rollno");
                xName = rs.getString("name");
                x = new User(xUserID, xName, xUsername, xPassword, xRollNO);
            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
    }
    
    //get user by id
    public User getUserbyId(String xId) {
        User x =null;
        xSql = "select * from userInfo where userID = ?";
        try {
            
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            rs = ps.executeQuery();
            int  xRollno;
            String xName, xusername, xpassword;
            while(rs.next()){
                xName = rs.getString("name");
                xusername = rs.getString("username");
                xpassword = rs.getString("password");
                xRollno = rs.getInt("Rollno");
                x = new User(Integer.parseInt(xId),xName,xusername,xpassword,xRollno);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

//    Sau khi kiểm tra các giá trị input, record sẽ được insert vào bảng userInfo với 
//    các giá trị là username, password và Rollno(giá trị mặc định là 2)
    public String UserRegister(User user) {
        try {
            xSql = "insert into userInfo(username,password, Rollno) values (?,?,2)";
            ps = con.prepareStatement(xSql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();

        } catch (Exception e) {
            //e.printStackTrace();
            return e.getMessage();
        }
        return "true";
    }

//    Kiểm tra xem input username nhập vào có bị trùng với username đã có trong [userInfo] hay không.
    public boolean CheckUsername(String username) {
        try {
            String sql = "SELECT password FROM userInfo WHERE username = '" + username + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//  Kiểm tra password nhập vào có đúng điều kiện không, điều kiên 
//  cụ thể ở đây là password phải có từ 8 đến 20 kí tự bao gồm chữ và số.
    public boolean checkPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z]).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);
        return m.matches();
    }

    //Update a Student
    public void update(int xUserID, User x) {
        xSql = "update userInfo set name=?, username=?,password=? where userID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getUsername());
            ps.setString(3, x.getPassword());
            ps.setInt(4, xUserID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String createAd(User user){
        try{
            xSql = "insert into userInfo(username,password, Rollno) values (?,?,1)";
            ps = con.prepareStatement(xSql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            
        }catch(Exception e){
            //e.printStackTrace();
            return e.getMessage();
        }
        return "true";
    }
    
    public void delete(String id) {
        xSql = "delete from userInfo where userID=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
