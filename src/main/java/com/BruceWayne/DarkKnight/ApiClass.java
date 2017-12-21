package com.BruceWayne.DarkKnight;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/Student")
public class ApiClass {
	
	@GET
	@Produces("application/json")
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
	
	@GET
	@Path("/{MID}")
	@Produces("application/json")
	public String getInfoByID(@PathParam("MID") int MID){
		StudentImply student=new StudentImply();
		StudentRoot result=new StudentRoot();
		student.setup();
		result=student.ReadId(MID);
		Gson gson=new Gson();
		String result1=gson.toJson(result);
		System.out.println(result1);
		return result1;
		
		
	}
	@POST
	@Path("/addmessage")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addMessage(@QueryParam("mid")int mid,@QueryParam("name") String name,
			@QueryParam("location")String location,@QueryParam("Lead")String Lead,
			@QueryParam("track")String track)	{
		
		StudentImply student=new StudentImply();	
		String response=student.addMessage(mid, name, location, Lead, track);
		return response;
		
}
	
	@DELETE
	@Path("/delete/{meesageid}")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteMessage(@PathParam("messageid")int id){
		System.out.println(id);
		StudentImply student=new StudentImply();
		student.Delete(id);
		return"Successfully deleted";
		
	}
}
