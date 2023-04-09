package student_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import student_bo.add_bo;
import student_bo.login_bo;

public class student_dao 
{

	
		public static Connection connect()
		{
			Connection con=null;
			
			 String url="jdbc:mysql://localhost:3306/codenera?useSSL=false&allowPublicKeyRetrieval=true";
			 String un="root";
			 String ps="Shivaji@21";
			 
			 try 
			 {
				 
				 Class.forName("com.mysql.jdbc.Driver");
				 
				 con=DriverManager.getConnection(url,un,ps);
				 
				 
			 }
			catch(Exception e)
			 {
				
				System.out.println(e);
			 }
			
			return con;
		}

	public static int signup(login_bo lb)
	{
		int status=0;
		
	try {
		
		Connection con=student_dao.connect();
		
		String query="insert into student(user_name,password,confrim_pass,name, DOB,city,course) values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1, lb.getUser_name());
		ps.setInt(2, lb.getPassword());
		ps.setInt(3, lb.getConfirm_pass());
		ps.setString(4, lb.getName());
		ps.setString(5, lb.getDob());
		ps.setString(6, lb.getCity());
		ps.setString(7, lb.getCourse());
		
		status=ps.executeUpdate();
		
	}
		catch(Exception e)
	{
			System.out.println(e);
	}
		return status;
	}

	
	public static boolean user_login(String user,int pass )
	{
		boolean status=false;
		
	try 
	{
		
		Connection con=student_dao.connect();
		
		String query="select * from student where user_name=? and password=?";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1, user);
		ps.setInt(2, pass);
		
		ResultSet rs=ps.executeQuery();
		
		status=rs.next();
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
		return status;
	}

	public static int add_emp(add_bo lb)
	{
		int status=0;
		
		try {
			
			Connection con=student_dao.connect();
			
			String query="insert into adddata(id,emp_name,email,phone,join_date, end_date,adhar) values (?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, lb.getId());
			ps.setString(2, lb.getName());
			ps.setString(3, lb.getEmail());
			ps.setString(4, lb.getPhone());
			ps.setString(5, lb.getDoj());
			ps.setString(6, lb.getEoj());
			ps.setString(7, lb.getAdhar());
			
			
			status=ps.executeUpdate();
			
			
		}
			catch(Exception e)
		{
				System.out.println(e);
		}
			return status;
		
		
		
	}
	
	
	public static List get_all_employee()
	{
		List<add_bo> ob=new ArrayList<add_bo>();
		
    try {
			
			Connection con=student_dao.connect();
			
			String query="select * from adddata";
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				add_bo ab=new add_bo();
				
				ab.setId(rs.getString(1));
				ab.setName(rs.getString(2));
				ab.setEmail(rs.getString(3));
				ab.setPhone(rs.getString(4));
				ab.setDoj(rs.getString(5));
				ab.setEoj(rs.getString(6));
				ab.setAdhar(rs.getString(7));
				
				ob.add(ab);
			}	
		}
			catch(Exception e)
		{
				System.out.println(e);
		}
		return ob;	
	}
	
	public static int delete(String id) 
	   {
			
			int status=0;
			  try {
			
				  Connection con=student_dao.connect();
				  String query="Delete from adddata where id=?";
				  PreparedStatement ps=con.prepareStatement(query);
				  ps.setString(1, id);
				  status=ps.executeUpdate();
				  
			} catch (Exception e) {
			
				   System.out.println(e);
			}
			
			return status;	
		}   
	
	public static add_bo getEmployeeById(String id) {
		 
		 add_bo eb=new add_bo();
		 
		   try {
			   Connection con=student_dao.connect();
			  
			   String query="select *from adddata where id=?";
			   
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setString(1, id);

			   ResultSet rs=ps.executeQuery();
			   
			   if(rs.next()) {
				   
				   eb.setId(rs.getString(1));
				   eb.setName(rs.getString(2));
				   eb.setEmail(rs.getString(3));
				   eb.setPhone(rs.getString(4));
				   eb.setDoj(rs.getString(5));
				   eb.setEoj(rs.getString(6));
				   eb.setAdhar(rs.getString(7));
				   
			   }
			   
			   
			   
		} catch (Exception e) {
		
			System.out.println(e);
			
		}
		  
		  
		  return eb;
	 }
	
	
	public static int Update(add_bo eb) {
		 int status=0;
		 
		 try {
			
			 Connection con=student_dao.connect();
			 
			 String query="update adddata set emp_name=?,email=?,phone=?, join_date=?,end_date=?,adhar=? where id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, eb.getName());
			 ps.setString(2, eb.getEmail());
	         ps.setString(3, eb.getPhone());
	         ps.setString(4, eb.getDoj());
	         ps.setString(5, eb.getEoj());
	         ps.setString(6, eb.getAdhar());
	         ps.setString(7, eb.getId());
			 
	         status=ps.executeUpdate();
	         
	         
	         
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		 
		 
		 return status;
	 }
}
