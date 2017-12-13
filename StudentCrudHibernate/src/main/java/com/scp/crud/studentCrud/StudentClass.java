package com.scp.crud.studentCrud;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Studenttable")
public class StudentClass implements Serializable {
	@Id
	@Column(name = "id_db")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="name_db")
	private String name;
	@Column(name="add_db")
	private String address;

public StudentClass() {
	super();
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAddress() {
	return address;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public void setAddress(String address) {
	this.address = address;
}
public StudentClass(int id,String name, String address) {
	super();
	this.id = id;
	this.name = name;
	
	this.address = address;
}

@Override
public String toString() {
	return "StudentClass [id=" + id + ", name=" + name + ", address=" + address + "]";
}


}





