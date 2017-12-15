package com.BruceWayne.DarkKnight;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class StudentRoot {
	
	private int MID;
	private String Name;
	private String Location;
	private String Lead;
	private String Track;
	public StudentRoot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentRoot(int mID, String name, String location, String lead, String track) {
		super();
		MID = mID;
		Name = name;
		Location = location;
		Lead = lead;
		Track = track;
	}
	@Id
	public int getMID() {
		return MID;
	}
	public void setMID(int mID) {
		MID = mID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getLead() {
		return Lead;
	}
	public void setLead(String lead) {
		Lead = lead;
	}
	public String getTrack() {
		return Track;
	}
	public void setTrack(String track) {
		Track = track;
	}
	

}

