package com.resoursetechmappings.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resourcebean")
public class ResourceBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name="empid")
	private long empId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "middlename")
	private String middleName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "listoftechworkedon")
	private String listOfTechWorkedOn;
	@Column(name = "certifications")
	private String certifications;
	@Column(name = "projects")
	private String projects;
	@Column(name = "applicationworkloadtypes")
	private String applicationWorkLoadTypes;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getListOfTechWorkedOn() {
		return listOfTechWorkedOn;
	}

	public void setListOfTechWorkedOn(String listOfTechWorkedOn) {
		this.listOfTechWorkedOn = listOfTechWorkedOn;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getApplicationWorkLoadTypes() {
		return applicationWorkLoadTypes;
	}

	public void setApplicationWorkLoadTypes(String applicationWorkLoadTypes) {
		this.applicationWorkLoadTypes = applicationWorkLoadTypes;
	}

	@Override
	public String toString() {
		return "ResourceBean [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", listOfTechWorkedOn=" + listOfTechWorkedOn + ", certifications=" + certifications
				+ ", projects=" + projects + ", applicationWorkLoadTypes=" + applicationWorkLoadTypes + "]";
	}

}
