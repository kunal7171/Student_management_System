package com.yck.sma.service;

import java.util.List;

import com.yck.sma.model.Student;

public interface ServiceI {

	public void saveStudent(Student s);

	public Student loginStudent(String username, String password);

	public List<Student> getAllStudents();

	public List<Student> paging(int pageNo, int size);
	
	public List<Student> searchStudentsbyBatch(String batchNo);

	public void deletedata(int studentId);

	public Student getStudentData(int studentId);

	public void updateStudentFess(int studentid, double ammount);

	public void updateStudentbatch(int studentid, String batchNo);

}
