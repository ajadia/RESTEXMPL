package com.wipro.mc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messageBodyWritter")
public class Impl_MessageBody_Writter {

	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee() {
		Employee emp = new Employee();
		emp.setEmpAge(20);
		emp.setEmpId(50);
		emp.setEmpEmail("jadiaankit25@gmail.com");
		emp.setEmpName("Madhu");
		emp.setEmpSalary(2.2f);
		return emp;
		
	}
	
	
//	public Date testDate() {
//		return Calendar.getInstance().getTime();
//	}
}
