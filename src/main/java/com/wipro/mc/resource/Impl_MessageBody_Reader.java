package com.wipro.mc.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("employees")
public class Impl_MessageBody_Reader {

@POST	
@Consumes(MediaType.APPLICATION_JSON)
public void messageBodyReader( Employee emp ) {
	if(emp !=null && !emp.equals("")) {
		//System.out.println(emp+" :Works: !! \n "+emp.getEmpEmail());
		System.out.println(emp+" :Works: !! \n ");
		System.out.println(" :Works Age: !!  "+emp.getEmpAge());
		System.out.println(" :Works Name: !! "+emp.getEmpName());
		System.out.println(" :Works Salary: !! "+emp.getEmpSalary());
		System.out.println(" :Works Email!!  "+emp.getEmpEmail());
		System.out.println(" :Works Id !!  "+emp.getEmpId());
	}else {
		System.out.println(" :Not Works: !! \n "+emp);
	}

}



}
