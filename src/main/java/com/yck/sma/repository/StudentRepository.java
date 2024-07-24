package com.yck.sma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yck.sma.model.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findByUsernameAndPassword(String username, String password);
	
	public List<Student> findAllByBatchNo(String batchNo);

}
