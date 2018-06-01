package com.javacodegeeks.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.javacodegeeks.spring.auditor.Auditable;


@Entity
@NamedQuery(name = "Employee.findEmployeesByName", query = "SELECT e.name FROM Employee e WHERE UPPER(e.name) = UPPER(:name)")
/*@NamedNativeQueries(value = {
		@NamedNativeQuery(
				name = "Employee.findEmployeesByName",
				query = "SELECT e.* FROM Employee e WHERE e.name = :name",
				resultClass = Employee.class),
		@NamedNativeQuery(
				name = "Book.findById",
				query = "SELECT e.* FROM Employee e WHERE e.id = :id",
				resultClass = Employee.class)
})*/
//public class Employee {
public class Employee extends Auditable<String>{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer age;

	public Employee(){}

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/*	@Override
	public String toString() {
		return "Employee (" + getId() + ", " + getName() + ", " + age + ")";
	}*/



	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		Employee o = (Employee) obj;

		return this.id.equals(o.getId());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}
