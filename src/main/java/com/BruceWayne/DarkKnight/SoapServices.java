package com.BruceWayne.DarkKnight;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.google.gson.Gson;

@WebService
public class SoapServices {
	@WebMethod
	public String AllMessages()
	{
		StudentImply student=new StudentImply();
		List<StudentRoot> stu=new ArrayList();
		stu=student.readAllMessages();
		Gson gson= new Gson();
		String j=gson.toJson(stu);
		System.out.println(j);
		return j;
		
	}

}
