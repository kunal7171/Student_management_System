package com.yck.sma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yck.sma.model.Student;
import com.yck.sma.repository.StudentRepository;

@Service
public class ServiceIMPL implements ServiceI  {
	@Autowired
	private StudentRepository sr;

	@Override
	public void saveStudent(Student s) {
		sr.save(s);
	}

	@Override
	public Student loginStudent(String username, String password) {
		 
		return sr.findByUsernameAndPassword(username, password) ;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}

	@Override
	public List<Student> paging(int pageNo, int size) {
		// TODO Auto-generated method stub
		Pageable p = PageRequest.of(pageNo, size,Sort.by("studentId").ascending());
		return sr.findAll(p).getContent();
	}

	@Override
	public List<Student> searchStudentsbyBatch(String batchNo) {
		List<Student> batchStudents = sr.findAllByBatchNo(batchNo);
		return batchStudents;
	}

	@Override
	public void deletedata(int studentId) {
		 sr.deleteById(studentId);
	}

	@Override
	public Student getStudentData(int studentId) {
		 Optional<Student>opstudent = sr.findById(studentId);
		return opstudent.get();
	}

	@Override
	public void updateStudentFess(int studentid, double ammount) {
		Optional<Student>opstu = sr.findById(studentid);
		Student st = opstu.get();
		double oldfees = st.getFeespaid();
		st.setFeespaid(oldfees+ammount);
		sr.save(st);
	}

	@Override
	public void updateStudentbatch(int studentid, String batchNo) {
		Optional<Student>op = sr.findById(studentid);
		Student s = op.get();
		s.setBatchNo(batchNo);
		sr.save(s);
	}
	
 }
	


