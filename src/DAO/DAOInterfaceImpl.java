
package DAO;

import DB.DbConnection;
import Model.Student;
import java.sql.*;


public class DAOInterfaceImpl implements DAOInterface {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag=true;
        
        try{
            Connection con=DbConnection.createConnection();
            String sql="insert into cus(fname , lname) value(? , ?)";
            PreparedStatement pst=con.prepareCall(sql);
            pst.setString(1, s.getFirstName());
            pst.setString(2, s.getLastName());
            pst.executeUpdate();
            flag=true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return flag;
    }

    @Override
    public void viewAll() {
        try{
            Connection con=DbConnection.createConnection();
            String sql="select * from cus";
            PreparedStatement pst=con.prepareCall(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
           System.out.println("Student_Id : "+rs.getInt(1) + " / "+ "FirstName : "+rs.getString("fname")+ " / "+"LastName : "+rs.getString("lname"));
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean viewAllById(int id) {
       
        try{
            boolean flag=false;
            Connection con=DbConnection.createConnection();
         String sql="select * from cus where cus_id="+id;
         PreparedStatement pst=con.prepareCall(sql);
         ResultSet rs=pst.executeQuery();
            while(rs.next()){
           System.out.println("Student_Id : "+rs.getInt(1) + " / "+ "FirstName : "+rs.getString("fname")+ " / "+"LastName : "+rs.getString("lname"));
           flag=true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public boolean updateStudent(int id,Student s) {
       boolean flag=false;
       try{
           Connection con=DbConnection.createConnection();
           String sql="update cus set fname=? , lname=? where cus_id="+id;
           PreparedStatement pst=con.prepareCall(sql);
           pst.setString(1, s.getFirstName());
            pst.setString(2, s.getLastName());
            pst.executeUpdate();
            flag=true;
           
       }catch(SQLException e){
           System.out.println(e);
       }
       return flag;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean flag=false;
        try{
            Connection con=DbConnection.createConnection();
            String sql="delete from cus where cus_id="+id;
            PreparedStatement pst=con.prepareCall(sql);
            pst.executeUpdate();
            flag=true;
        }catch(Exception e){
            System.out.println(e);
        }
        return flag;
    }
    
}
