package com.masai.dao;

import java.util.List;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.exceptions.AdminException;

public interface AdminDao {

	public String loginAdmin(String username, String password) throws AdminException;
	
	public String addNewCourse(Course course);
	
	public String updateFeeBY10Percent(int cid);
	
	public List<Course> getAllCources() throws AdminException;
	
	public String createNewBatch(Batch batch);
	
	public String updatenoOfStudentInBatch(int no, int batchId);
	
	public List<Batch> seeAllOnGoingBatches() throws AdminException;
	
}
