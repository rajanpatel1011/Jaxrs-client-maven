package com.org;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class TestJaxRSGetEmployee {

	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget rootTarget = client.target("http://localhost:9090/Maven-CRUD-demo/webapi/employeeService/");
		WebTarget getEmployee = rootTarget.path("get").path("26");
		Invocation.Builder invocationBuilder = getEmployee.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
//		String content = response.readEntity(String.class);
	Employee emp = response.readEntity(Employee.class);
	
		System.out.println("Employe Id "+emp.getEmpId()+"NAme"+emp.getEmpName()+"Salary"+emp.getEmpSalary());
	}

}
