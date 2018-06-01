package com.javacodegeeks.spring.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.javacodegeeks.spring.jpa.Employee;

//
public interface EmployeeRepository extends CrudRepository<Employee,String>,QueryDslPredicateExecutor<Employee>{

	List<Employee> findEmployeesByAge(int age);

	//@Query("SELECT e FROM Employee e WHERE LOWER(e.name) = LOWER(:name)")
	//@Query(value="SELECT e.* FROM Employee e WHERE LOWER(e.name) = LOWER(:name)",nativeQuery=true)
	List<Employee> findEmployeesByName(@Param("name") String name);

	@Query("select emp from Employee emp where emp.age >= ?1 and emp.age <= ?2")
	List<Employee> findEmployeesBetweenAge(int from, int to);

	Page<Employee> findEmployeesByAgeGreaterThan(int age, Pageable pageable);

	@Modifying
	@Transactional
	@Query("update Employee set name=?2 where id=?1")
	int updateByName(long id, String name);
}
