package com.org;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestJaxRSClient {

	public static void main(String[] args) throws Exception {
		
		Client client = ClientBuilder.newClient();
		WebTarget rootTarget = client.target("http://localhost:9090/Maven-CRUD-demo/webapi/employeeService/");
		
		WebTarget path = rootTarget.path("store");
		//String postConent = "<employee><empId>25</empId><empName>raju</empName><empSalary>366600</empSalary></employee>";
		Employee postConent = new Employee(26,"rajuriska",444444);
		
		Invocation.Builder invocationBulider = path.request();
		Response res = invocationBulider.post(Entity.entity(postConent, MediaType.APPLICATION_XML));
		if(res.getStatus()!=201) {
			throw new RuntimeException("Employee is not created");
		}else {
			System.out.println(res.readEntity(String.class));
		}
	}

}
