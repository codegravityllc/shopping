package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersTable {

	public static void main(String args[]) {
		Connection conn=null;
		try {
			conn = DatabaseConnection.getDBConnection();
			conn.setAutoCommit(false);
			//registerUser("j", "j", conn);
			//updatePwd("j", "java", conn);
			deleteUser("j", conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		}finally {
			try {
				conn.close();
			}catch(Exception ee) {}
		}
	}
	//registerUser("michael","michael1!",conn);
	public static void registerUser(String uid,String pwd,  Connection conn) throws  SQLException
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement
            		("insert into users (userid,password) values ( ?,? )");
            stmt.setString(1, uid); // dynamic binding
            stmt.setString(2, pwd);
            int count= stmt.executeUpdate();
            System.out.println("records created :"+count);
        }
        catch (SQLException e)
        {
        	throw e;
        }
        finally
        {
            try{
            	stmt.close();} catch(SQLException s){}
        }
    }

	
	//updateOrder("john","new_pasword")
	public static void updatePwd(String uid,String pwd, Connection conn) throws  SQLException
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement("update users set password=? where userid=?");
            stmt.setString(1, pwd);
            stmt.setString(2, uid);
            int rowUpdates=stmt.executeUpdate();
        }
        catch (SQLException e)
        {
        	throw e;
        }
        finally
        {
            try{
            	stmt.close();} catch(SQLException s){}
        }
     
    }
	

	public static void deleteUser(String delUid,Connection conn) throws  SQLException
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement("delete from users where userid=?");
            stmt.setString(1, delUid);
            int rowsupdated=stmt.executeUpdate();
            System.out.println("records deleted:"+rowsupdated);
        }
        catch (SQLException e)
        {
        	throw e;
        }
        finally
        {
            try{
            	stmt.close();} catch(SQLException s){}
        }
     
    }



	public static boolean validateLogin(String userid,String pwd,Connection conn) throws SQLException 
    {
		//date="03/20/15"
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        boolean result=false;
        try
        {
        	stmt = conn.
        			prepareStatement
        			("select userid from users where userid =? and password=?");
        	stmt.setString(1, userid);
        	stmt.setString(2, pwd);
            resultSet = stmt.executeQuery();
            if(resultSet.next())
            {
            	result=true;
            }/* sample code to read multiple records
            ArrayList<product> prductList=new ArrayList<product> (); 
            while(resultSet.next())
            {
            	Product p=new Product();
            	p.setProdName(resultSet.getString("product_name"));
            	p.setEnroStatus(resultSet.getString("enrollment_status"));
            	productList.add(p);
            }
            */
            return result;
        }
        catch (SQLException e)
        {
        	System.out.println("Exception occired");
        	e.printStackTrace();
            throw e;
        }
        finally
        {
        	try{
        		resultSet.close(); } catch(SQLException s){}
            try{
            	stmt.close();} catch(SQLException s){}
            
        }
        
    }
	

}







