package id.co.skyforce.basicjsf.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MyFirstController {
	
	private String message;
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void sayHello(){
		message= "hello "+name;
	}
	public String sayHelloAgain(){
		message= "hello hello "+name;
		return "output";
	}
}
