package com.training.mphasis.interview_repository;


public class Candidate {
	
	private String name;
	private String technicl_expertise;
	private String city;
	private int years_of_experience;
	
	

	public Candidate(String name, String technicl_expertise, String city, int years_of_experience) {
		super();
		this.name = name;
		this.technicl_expertise = technicl_expertise;
		this.city = city;
		this.years_of_experience = years_of_experience;
	}


	public String getName() {
		return name;
	}


	public String getTechnicl_expertise() {
		return technicl_expertise;
	}


	public String getCity() {
		return city;
	}


	public int getYears_of_experience() {
		return years_of_experience;
	}


	@Override
	public String toString() {
		return "Candidate [name=" + name + ", technicl_expertise=" + technicl_expertise + ", city=" + city
				+ ", years_of_experience=" + years_of_experience + "]";
	}
	
	

}
