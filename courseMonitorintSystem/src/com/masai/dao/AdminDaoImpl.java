package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.exceptions.AdminException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String loginAdmin(String username, String password) throws AdminException {
		String res = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? && password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("password");
				
				res = name;
			}else {
				throw new AdminException("Invalid Username or password.. ");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

		return res;
	}

	
	
	@Override
	public String addNewCourse(Course course) {
		String str = "Something went wrong..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into course (courseName,fee,courseDescription) values(?,?,?)");
			
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getFees());
			ps.setString(3,course.getCourseDescription());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				str = "Course added sucessfully!";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return str;
	}
	
	
	



	@Override
	public String updateFeeBY10Percent(int cid) {
		String res = "Course not exist with this course ID...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update course set fee = fee+(fee*10/100) where courseId=?;");
			ps.setInt(1, cid);
			
			int x = ps.executeUpdate();
			if(x>0) {
				res = "Fees Updated Sucessfully..";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return res;
	}



	@Override
	public List<Course> getAllCources() throws AdminException {
		List<Course> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("courseId");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String cdesc = rs.getString("courseDescription");
				
				Course course = new Course(id,name,fee,cdesc);
				list.add(course);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());		
		
		}
		
		if(list.size()==0) {
			throw new AdminException("No Course found..");
		}
		
		return list;
	}



	@Override
	public String createNewBatch(Batch batch) {
		
		String str = "Something went wrong...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into batch (courseId,numberOfStudents,batchStartDate,duration) values (?,?,?,?)");
			
			ps.setInt(1, batch.getCourseId());
			ps.setInt(2, batch.getNumberOfStudents());
			ps.setString(3, batch.getBatchStartDate());
			ps.setString(4, batch.getDuration());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				str = "Batch Created Sucessfully";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return str;
		
	}



	@Override
	public String updatenoOfStudentInBatch(int no, int batchId) {
		String res = "Batch does not exist...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update batch set numberOfStudents = ? where batchId=?;");
			ps.setInt(1, no);
			ps.setInt(2, batchId);
			
			int x = ps.executeUpdate();
			if(x>0) {
				res = "No. of Students updated sucessfully...";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return res;
	}



	@Override
	public List<Batch> seeAllOnGoingBatches() throws AdminException {
		List<Batch> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from batch");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int batchId = rs.getInt("batchId");
				int courseId = rs.getInt("courseId");
				int facultyId = rs.getInt("facultyId");
				int noOfStud = rs.getInt("numberOfStudents");
				String batchStartDate = rs.getString("batchStartDate");
				String duration =rs.getString("duration");
				
				Batch batch = new Batch(batchId,courseId,facultyId,noOfStud,batchStartDate,duration);
				list.add(batch);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());		
		
		}
		
		if(list.size()==0) {
			throw new AdminException("No Batch found..");
		}
		
		return list;
	}

	
	
}
