package com.jspiders.musicplayerhibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Song")
public class Songdto {
  
	@Id
	private int number;
	private String name;
	private String singer;
	private double duration;

	
	 public Songdto(int nu,String n,String s,double d) {
		this.number=nu;
		this.name=n;
		this.singer=s;
		this.duration=d;
		
	}

	
	@Override
	public String toString() {
		return "Song number="
	           + number + ",song name=" + name + 
	           ", singer of the song=" + singer 
				+ ", song duration is=" + duration ;
	}
	public Songdto(){

	}
	
	
}

