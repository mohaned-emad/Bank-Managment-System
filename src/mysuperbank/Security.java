/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysuperbank;

/**
 *
 * @author Mohaned
 */
import java.sql.*;

public class Security {
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost/bank";
    static Connection c;
    static Statement ss;
    static ResultSet rs;
    static String query;
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
    
    public boolean insert(Account account){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            query = String.format
                    ("insert into customers (Name, Phone, Age, Gender, City, balance, pass)"
                            + " values ('%s','%s',%d,'%s','%s',%.2f,'%s')",
                            account.getName(),
                            account.getPhone(),
                            account.getAge(),
                            account.getGender(),
                            account.getCity(),
                            account.getBalance(),
                            account.getPass()
                    );
            ss.execute(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
            return false;
        }
        return true;
    }
    public void editBalance(int id, double balance){
        Security s = new Security();
        ResultSet rs = s.selectCustomer(id);
        try{
            rs.next();
            c = s.connect();
            ss = c.createStatement();
            query = String.format
            (
                    "update customers set balance = %.2f where id = %d",
                     rs.getFloat("balance") + balance, id
            );
            ss.execute(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    
    public boolean editCity(int id, String city){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            ResultSet rs = selectCustomer(id);
            if(rs.next() == false)
                return false;
            query = String.format("update customers set City = '%s' where id = %d", city, id);
            ss.execute(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
        return true;
    }
    
    public boolean editPhone(int id, String phone){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            ResultSet rs = selectCustomer(id);
            if(rs.next() == false)
                return false;
            query = String.format("update customers set Phone = '%s' where id = %d", phone, id);
            ss.execute(query);
        }
        catch(SQLException ee){
            System.err.println(ee.getMessage());
        }
        
        return true;
    }

    public boolean delete(int id){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            ResultSet rs = selectCustomer(id);
            if(rs.next() == false){
                return false;
            }
            query = String.format("delete from transactions where customer_id = %d", id);
            ss.execute(query);
            query = String.format("delete from customers where id = %d", id);
            ss.execute(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
            return false;
        }
        return true;
    }
    
    public ResultSet showAll(){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            query = "select id, Name, Phone, Age, Gender, City, balance from customers";
            rs = ss.executeQuery(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
        return rs;
    }
    
    public ResultSet showTransactionS(int id){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            query = String.format("select * from transactions where customer_id = %d", id);
            rs = ss.executeQuery(query);
        }
        catch (SQLException ee){
            System.out.println(ee.getMessage());
        }
        return rs;
    }
    
    public ResultSet showAllTransactions(){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            query = "select * from transcations";
            rs = ss.executeQuery(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
        return rs;
    }
    
    public ResultSet selectCustomer(int id){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            query = String.format("select * from customers where id = %d", id);
            rs = ss.executeQuery(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
        return rs;
    }
    
    public void insertDeposit(int id, double money){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            ResultSet rs = selectCustomer(id);
            rs.next();
            query = "insert into transactions values(NULL, 'deposit', CURRENT_TIMESTAMP, "+id+", "+money+", "+rs.getFloat("balance")+")";
            ss.execute(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
    public void insertWithdraw(int id, double money){
        Security s = new Security();
        try{
            c = s.connect();
            ss = c.createStatement();
            ResultSet rs = selectCustomer(id);
            rs.next();
            query = "insert into transactions values(NULL, 'withdraw', CURRENT_TIMESTAMP, "+id+", "+money+", "+rs.getFloat("balance")+")";
            ss.execute(query);
        }
        catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }
}
