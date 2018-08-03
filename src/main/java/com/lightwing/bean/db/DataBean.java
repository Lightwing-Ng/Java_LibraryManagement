package com.lightwing.bean.db;

import com.lightwing.bean.*;
import com.lightwing.util.MyDate;
import com.lightwing.util.MyString;

import java.sql.*;
import java.util.ArrayList;

public class DataBean {
    private Connection conn = null;

    private ResultSet res = null;

    private java.sql.PreparedStatement prepar = null;

    private java.sql.CallableStatement proc = null;

    public int pagecount = 0;

    public DataBean() { // 构造函数
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            conn = DriverManager
                    .getConnection(
                            "jdbc:microsoft:sqlserver://127.0.0.1:1433;databasename=Book",
                            "sa", "");
            System.out.println("连接成功");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "路径错误");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + "驱动错误");
        }

    }

    public void Close() { //关闭方法
        try {
            if (res != null) {
                res.close();
            }
            if (prepar != null) {
                prepar.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("关闭成功");
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Admin登陆方法/////////////////////////////////////////////////
    public boolean checkAdminLogin(AdminBean ab) { // 验证登陆

        boolean result = false;
        if (!MyString.checkParameter(ab.getAdmin_Name()
                + ab.getAdmin_Pwd())) {
            return false;
        }
        try {
            String sql =
                    "SELECT count(*) FROM Admin WHERE Admin_Name=? AND Admin_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ab.getAdmin_Name());
            prepar.setString(2, ab.getAdmin_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                if (res.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public AdminBean getAdminBean(AdminBean ab) { // 获取AdminBean持久化
        AdminBean admin = null;
        try {
            String sql =
                    "SELECT * FROM Admin WHERE Admin_Name=? AND Admin_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ab.getAdmin_Name());
            prepar.setString(2, ab.getAdmin_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                admin = new AdminBean();
                admin.setAdmin_ID(res.getInt("Admin_ID"));
                admin.setAdmin_Name(res.getString("Admin_Name"));
                admin.setAdmin_Pwd(res.getString("Admin_Pwd"));
                admin.setAdmin_Flag(res.getString("Admin_Flag"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////User登陆方法/////////////////////////////////////////////////
    public boolean checkUserLogin(UserBean ub) { // 验证登陆

        boolean result = false;
        if (!MyString.checkParameter(ub.getUsers_Name()
                + ub.getUsers_Pwd())) {
            return false;
        }
        try {
            String sql =
                    "SELECT count(*) FROM Users WHERE Users_Name=? AND Users_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                if (res.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public UserBean getUserBean(UserBean ub) { // 获取UserBean持久化
        UserBean user = null;
        try {
            String sql =
                    "SELECT * FROM Users WHERE Users_Name=? AND Users_Pwd=?";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            res = prepar.executeQuery();
            if (res.next()) {
                user = new UserBean();
                user.setUsers_ID(res.getInt("Users_ID"));
                user.setUsers_Name(res.getString("Users_Name"));
                user.setUsers_Pwd(res.getString("Users_Pwd"));
                user.setUsers_Adds(res.getString("Users_Adds"));
                user.setUsers_Class(res.getString("Users_Class"));
                user.setUsers_Count(res.getInt("Users_Count"));
                user.setUsers_Phone(res.getString("Users_Phone"));
                user.setUsers_Sex(res.getString("Users_Sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public UserBean getUserBean(int users_ID) { // 获取UserBean持久化
        UserBean user = null;
        try {
            String sql =
                    "SELECT * FROM Users WHERE Users_ID=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, users_ID);
            res = prepar.executeQuery();
            if (res.next()) {
                user = new UserBean();
                user.setUsers_ID(res.getInt("Users_ID"));
                user.setUsers_Name(res.getString("Users_Name"));
                user.setUsers_Pwd(res.getString("Users_Pwd"));
                user.setUsers_Adds(res.getString("Users_Adds"));
                user.setUsers_Class(res.getString("Users_Class"));
                user.setUsers_Count(res.getInt("Users_Count"));
                user.setUsers_Phone(res.getString("Users_Phone"));
                user.setUsers_Sex(res.getString("Users_Sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////User注册方法/////////////////////////////////////////////////
    public boolean regUser(UserBean ub) {
        try {
            prepar = conn.prepareStatement(
                    "INSERT INTO Users (Users_Name,Users_Pwd,Users_Class,Users_Sex,Users_Count,Users_Phone,Users_Adds) VALUES(?,?,?,?,?,?,?)");
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            prepar.setString(3, ub.getUsers_Class());
            prepar.setString(4, ub.getUsers_Sex());
            prepar.setInt(5, ub.getUsers_Count());
            prepar.setString(6, ub.getUsers_Phone());
            prepar.setString(7, ub.getUsers_Adds());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    private boolean isHasName(String userName) {
        try {
            prepar = conn.prepareStatement(
                    "SELECT count(*) FROM Users WHERE Users_Name=?");
            prepar.setString(1, userName);
            res = prepar.executeQuery();
            res.next();
            if (res.getInt(1) != 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            this.Close();
        }
        return true;
    }

    public static boolean HasName(String userName) {
        return new DataBean().isHasName(userName);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////User更新信息方法/////////////////////////////////////////////////
    public boolean updateUserInfo(UserBean ub) {
        try {
            prepar = conn.prepareStatement(
                    "UPDATE Users SET Users_Name=?,Users_Pwd=?,Users_Class=?,Users_Sex=?,Users_Phone=?,Users_Adds=? WHERE Users_ID=?");
            prepar.setString(1, ub.getUsers_Name());
            prepar.setString(2, ub.getUsers_Pwd());
            prepar.setString(3, ub.getUsers_Class());
            prepar.setString(4, ub.getUsers_Sex());
            prepar.setString(5, ub.getUsers_Phone());
            prepar.setString(6, ub.getUsers_Adds());
            prepar.setInt(7, ub.getUsers_ID());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Users获取User已借书的列表方法/////////////////////////////////////////////////
    public ArrayList getUsersLendList(int users_ID) {
        ArrayList list = new ArrayList();
        try {
            String sql =
                    "SELECT * FROM BookLend WHERE Users_ID=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, users_ID);
            res = prepar.executeQuery();
            while (res.next()) {
                LendBean lb = new LendBean();
                lb.setBookLend_ID(res.getInt("BookLend_ID"));
                lb.setBooks_ID(res.getInt("Books_ID"));
                lb.setBookLend_StarTime(res.getString("BookLend_StarTime"));
                lb.setBookLend_EndTime(res.getString("BookLend_EndTime"));
                lb.setUsers_ID(res.getInt("Users_ID"));
                list.add(lb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Users获取User已借书的列表方法/////////////////////////////////////////////////
    public ArrayList getUsersList(int count, int page) {
        ArrayList list = new ArrayList();
        try {
            proc = conn.prepareCall("{call UsersPage (?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.registerOutParameter(3, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                UserBean ub = new UserBean();
                ub.setUsers_ID(res.getInt(1));
                ub.setUsers_Name(res.getString(2));
                ub.setUsers_Pwd(res.getString(3));
                ub.setUsers_Class(res.getString(4));
                ub.setUsers_Sex(res.getString(5));
                ub.setUsers_Count(res.getInt(6));
                ub.setUsers_Phone(res.getString(7));
                ub.setUsers_Adds(res.getString(8));
                list.add(ub);
            }
            pagecount = proc.getInt(3);
        } catch (SQLException ex) {
            System.out.println("服务器异常发生在 getUsersList()");
            ex.printStackTrace();
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////User删除方法/////////////////////////////////////////////////
    public boolean deleteUsers(int users_ID) {
        try {
            prepar = conn.prepareStatement(
                    "DELETE Users WHERE Users_ID=?");
            prepar.setInt(1, users_ID);
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books获取BookType方法/////////////////////////////////////////////////
    public ArrayList getBooksType() {
        ArrayList list = new ArrayList();
        try {
            String sql =
                    "SELECT * FROM BookType";
            prepar = conn.prepareStatement(sql);
            res = prepar.executeQuery();
            while (res.next()) {
                BooksTypeBean btb = new BooksTypeBean();
                btb.setBookType_ID(res.getInt(1));
                btb.setBookType_Name(res.getString(2));
                list.add(btb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books获取列表方法/////////////////////////////////////////////////
    public ArrayList getBooksList(int count, int page, String sqlstr) {
        ArrayList list = new ArrayList();
        try {
            proc = conn.prepareCall("{call BooksPage (?,?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.setString(3, sqlstr);
            proc.registerOutParameter(4, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                BooksBean bsb = new BooksBean();
                bsb.setBooks_Amount(res.getInt("Books_Amount"));
                bsb.setBooks_Company(res.getString("Books_Company"));
                bsb.setBooks_Count(res.getInt("Books_Count"));
                bsb.setBooks_ID(res.getInt("Books_ID"));
                bsb.setBooks_Name(res.getString("Books_Name"));
                bsb.setBooks_Time(res.getString("Books_Time"));
                bsb.setBookType_ID(res.getInt("BookType_ID"));
                list.add(bsb);
            }
            pagecount = proc.getInt(4);
        } catch (SQLException ex) {
            System.out.println("服务器异常发生在 getBooksList()");
            ex.printStackTrace();
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books获取Book持久化方法/////////////////////////////////////////////////
    public BooksBean getBooksBean(int books_ID) {
        BooksBean bsb = new BooksBean();
        try {
            String sql =
                    "SELECT * FROM Books WHERE Books_ID=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, books_ID);
            res = prepar.executeQuery();
            if (res.next()) {
                bsb.setBooks_Amount(res.getInt("Books_Amount"));
                bsb.setBooks_Company(res.getString("Books_Company"));
                bsb.setBooks_Count(res.getInt("Books_Count"));
                bsb.setBooks_ID(res.getInt("Books_ID"));
                bsb.setBooks_Name(res.getString("Books_Name"));
                bsb.setBooks_Time(res.getString("Books_Time"));
                bsb.setBookType_ID(res.getInt("BookType_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bsb;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books执行借书方法/////////////////////////////////////////////////
    public String lendBooks(LendBean lb) {
        try {
            proc = conn.prepareCall("{call LendBook (?,?,?,?,?)}");
            proc.setInt(1, lb.getUsers_ID());
            proc.setInt(2, lb.getBooks_ID());
            proc.setString(3, lb.getBookLend_StarTime());
            proc.setString(4, lb.getBookLend_EndTime());
            proc.registerOutParameter(5, Types.VARCHAR);
            proc.executeUpdate();
            return proc.getString(5);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "借书失败";
    }

    ////////////////获取日期之差
    public int getDateCha(String stra, String end) {
        try {
            String sql =
                    "SELECT datediff(day,?,?)";
            prepar = conn.prepareStatement(sql);
            prepar.setString(1, stra);
            prepar.setString(2, end);
            res = prepar.executeQuery();
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books录入方法/////////////////////////////////////////////////
    public boolean insertBooks(BooksBean bsb) {
        try {
            prepar = conn.prepareStatement(
                    "INSERT INTO Books (Books_Name,Books_Company,Books_Time,BookType_ID) VALUES(?,?,?,?)");
            prepar.setString(1, bsb.getBooks_Name());
            prepar.setString(2, bsb.getBooks_Company());
            prepar.setString(3, MyDate.getDate());
            prepar.setInt(4, bsb.getBookType_ID());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books删除方法/////////////////////////////////////////////////
    public boolean deleteBooks(int books_ID) {
        try {
            prepar = conn.prepareStatement(
                    "DELETE Books WHERE Books_ID=?");
            prepar.setInt(1, books_ID);
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books修改方法/////////////////////////////////////////////////
    public boolean updateBooks(BooksBean bsb) {
        try {
            prepar = conn.prepareStatement(
                    "UPDATE Books SET Books_Name=?,Books_Company=?,Books_Count=?,BookType_ID=? WHERE Books_ID=?");
            prepar.setString(1, bsb.getBooks_Name());
            prepar.setString(2, bsb.getBooks_Company());
            prepar.setInt(3, bsb.getBooks_Count());
            prepar.setInt(4, bsb.getBookType_ID());
            prepar.setInt(5, bsb.getBooks_ID());
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Books归还方法/////////////////////////////////////////////////
    public String giveBook(LendBean lb) {
        try {
            proc = conn.prepareCall("{call GiveBook (?,?,?,?,?,?)}");
            proc.setInt(1, lb.getUsers_ID());
            proc.setInt(2, lb.getBooks_ID());
            proc.setString(3, lb.getBookLend_StarTime());
            proc.setString(4, lb.getBookLend_EndTime());
            proc.setString(5, MyDate.getDate());
            proc.registerOutParameter(6, Types.VARCHAR);
            proc.executeUpdate();
            return proc.getString(6);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Lend获取借书信息方法/////////////////////////////////////////////////
    public LendBean getLendBean(int lend_ID) {
        LendBean lb = new LendBean();
        try {
            String sql =
                    "SELECT * FROM BookLend WHERE BookLend_ID=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, lend_ID);
            res = prepar.executeQuery();
            if (res.next()) {
                lb.setBookLend_ID(res.getInt(1));
                lb.setUsers_ID(res.getInt(2));
                lb.setBooks_ID(res.getInt(3));
                lb.setBookLend_StarTime(res.getString(4));
                lb.setBookLend_EndTime(res.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lb;
    }

    public LendBean getLendBean(int users_ID, int books_ID) {
        LendBean lb = new LendBean();
        try {
            String sql =
                    "SELECT * FROM BookLend WHERE Users_ID=? AND Books_ID=?";
            prepar = conn.prepareStatement(sql);
            prepar.setInt(1, users_ID);
            prepar.setInt(2, books_ID);
            res = prepar.executeQuery();
            if (res.next()) {
                lb.setBookLend_ID(res.getInt(1));
                lb.setUsers_ID(res.getInt(2));
                lb.setBooks_ID(res.getInt(3));
                lb.setBookLend_StarTime(res.getString(4));
                lb.setBookLend_EndTime(res.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lb;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Lend获取借书列表方法/////////////////////////////////////////////////
    public ArrayList getLendList(int count, int page) {
        ArrayList list = new ArrayList();
        try {
            proc = conn.prepareCall("{call LendPage (?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.registerOutParameter(3, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                LendBean lb = new LendBean();
                lb.setBookLend_EndTime(res.getString("BookLend_EndTime"));
                lb.setBookLend_ID(res.getInt("BookLend_ID"));
                lb.setBookLend_StarTime(res.getString("BookLend_StarTime"));
                lb.setBooks_ID(res.getInt("Books_ID"));
                lb.setUsers_ID(res.getInt("Users_ID"));
                list.add(lb);
            }
            pagecount = proc.getInt(3);
        } catch (SQLException ex) {
            System.out.println("服务器异常发生在 getLendList()");
            ex.printStackTrace();
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Punish获取罚单列表方法/////////////////////////////////////////////////
    public ArrayList getPunishList(int count, int page) {
        ArrayList list = new ArrayList();
        try {
            proc = conn.prepareCall("{call PunishPageAdmin (?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.registerOutParameter(3, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                PunishBean pb = new PunishBean();
                pb.setBooks_ID(res.getInt("Books_ID"));
                pb.setPunish_Day(res.getInt("Punish_Day"));
                pb.setPunish_ID(res.getInt("Punish_ID"));
                pb.setPunish_Money(res.getInt("Punish_Money"));
                pb.setUsers_ID(res.getInt("Users_ID"));
                list.add(pb);
            }
            pagecount = proc.getInt(3);
        } catch (SQLException ex) {
            System.out.println("服务器异常发生在 getPunishList()");
            ex.printStackTrace();
        }
        return list;
    }

    public ArrayList getUserPunishList(int count, int page, int users_ID) {
        ArrayList list = new ArrayList();
        try {
            proc = conn.prepareCall("{call PunishPage (?,?,?,?)}");
            proc.setInt(1, page);
            proc.setInt(2, count);
            proc.setInt(3, users_ID);
            proc.registerOutParameter(4, Types.INTEGER);
            res = proc.executeQuery();
            while (res.next()) {
                PunishBean pb = new PunishBean();
                pb.setBooks_ID(res.getInt("Books_ID"));
                pb.setPunish_Day(res.getInt("Punish_Day"));
                pb.setPunish_ID(res.getInt("Punish_ID"));
                pb.setPunish_Money(res.getInt("Punish_Money"));
                pb.setUsers_ID(res.getInt("Users_ID"));
                list.add(pb);
            }
            pagecount = proc.getInt(4);
        } catch (SQLException ex) {
            System.out.println("服务器异常发生在 getPunishList()");
            ex.printStackTrace();
        }
        return list;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Punish付款后删除方法/////////////////////////////////////////////////
    public boolean deletePunish(int punish_ID) {
        try {
            prepar = conn.prepareStatement(
                    "DELETE Punish WHERE Punish_ID=?");
            prepar.setInt(1, punish_ID);
            int flag = prepar.executeUpdate();
            if (flag == 0) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
