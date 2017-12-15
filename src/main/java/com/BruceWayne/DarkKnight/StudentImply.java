package com.BruceWayne.DarkKnight;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class StudentImply {
	
	protected SessionFactory sessionFactory ;
	public void setup(){
		// A SessionFactory is set up once for an application!
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	protected void exit(){
		sessionFactory.close();
	}
	
	public void create(int Mid, String name,String location,String track,String LeadName){
		
		StudentRoot student=new StudentRoot();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		student.setMID(Mid);
		student.setName(name);
		student.setLocation(location);
		student.setTrack(track);
		student.setLead(LeadName);
		session.save(student);
		session.getTransaction().commit();
		session.close();
		System.out.println("SuccessFully Inserted Record into the Datbase");
		
	}
	public void Read(int mid){
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StudentRoot st=session.get(StudentRoot.class, mid);
		System.out.println("Mid \t\t Name \t\t Location \t\t Track \t\t LeadName");
		System.out.println(st.getMID()+"\t\t"+st.getName()+"\t\t"+st.getLocation()+"\t\t"+st.getTrack()+"\t\t"+st.getLead());
		
	}
	public StudentRoot ReadId(int mid){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StudentRoot student=session.get(StudentRoot.class, mid);
		return student;
	}
	public void Delete(int mid){
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StudentRoot student=new StudentRoot();
		student.setMID(mid);
		session.delete(student);
		System.out.println("Student"+mid+" is sucessfully deleted");
		session.getTransaction().commit();
		session.close();
	}
	public List<StudentRoot> readAllMessages(){
		setup();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<StudentRoot> list=new ArrayList();
		String query=" from StudentRoot";
		list=session.createQuery(query).list();
		System.out.println();
		System.out.println("=========================ALL DETAILS=============================");
		for(int i=0;i<list.size();i++)
		{
			System.out.println("Mid \t\t Name \t\t Location \t\t Track \t\t LeadName");
		System.out.println(list.get(i).getMID()+" \t "+list.get(i).getName()+" \t "+list.get(i).getLocation()+" \t "+list.get(i).getTrack()+" \t "+list.get(i).getLead());
		}
		return list;
	}
	public String addMessage(int mid,String Name,String location,String lead,String track){
		setup();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		StudentRoot student=new StudentRoot();
		student.setMID(mid);
		student.setName(Name);
		student.setLocation(location);
		student.setLead(lead);
		student.setTrack(track);
		session.save(student);
		session.getTransaction().commit();
		session.close();
		return "Message Successfully Inserted";
	
		
	}
	
}

