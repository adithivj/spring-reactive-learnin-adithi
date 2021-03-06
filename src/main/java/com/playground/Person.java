package com.playground;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import org.springframework.data.annotation.Id;
@Component
@Document
@XmlRootElement (name = "person")
public class Person  implements Serializable {
@Id
  private String id;
	
  private String name;
  
  private int age;
  
  public Person(){
	  
  }
  public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Person ( String name, int age) {
	  this.name = name;
	  this.age= age;
  }

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
}



  
}
