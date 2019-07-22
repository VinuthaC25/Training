package com.training.mphasis.interview_repository;

import java.util.ArrayList;
import java.util.List;

public class InterviewRepository {
	
	List<Candidate> candidates = null;
	
	

	public InterviewRepository()
	{
		candidates = new ArrayList<>();
		
		candidates.add(new Candidate("Vinutha","JAVA","Bangalore",12));
		candidates.add(new Candidate("Sagar","C","Hyderabad",11));
		candidates.add(new Candidate("Paddu","C++","Indore",17));
		candidates.add(new Candidate("Arpitha","SQL","Noida",19));
		candidates.add(new Candidate("Dhanush","JAVA","Rajamandri",15));
		candidates.add(new Candidate("Ravi","SQL","Indore",14));
		candidates.add(new Candidate("Arpitha","SQL","Noida",19));
		candidates.add(new Candidate("Dhanush","JAVA","Rajamandri",15));
		candidates.add(new Candidate("Ravi","SQL","Kurnool",14));
		
	}
	
	public void addCandidate(Candidate c)
	{
		candidates.add(c);
	}
	
	public Candidate getCandidate(int index)
	{
		Candidate c = candidates.get(index);
		return c;
	}
	
	
	public void deleteCandidate(int index)
	{
		candidates.remove(index);
	}

	public List <Candidate> getAllCandidates() {
	
		return candidates;
	}

}
