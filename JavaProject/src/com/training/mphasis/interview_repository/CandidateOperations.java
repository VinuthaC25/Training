package com.training.mphasis.interview_repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateOperations {

	public static void main(String[] args) {
		
		InterviewRepository repo = new InterviewRepository();
		List<Candidate> candidates = repo.getAllCandidates();
		System.out.println("-------------------------------");
		
		for(Candidate c:candidates)
		{
			System.out.println(c.getName()+" "+c.getTechnicl_expertise()+" "+c.getCity()+" "+c.getYears_of_experience());
		}
		
		System.out.println("1.Candidates from Indore\n"+"2.list city and count of candidates\n"
				+"3.technical expertise and count\n"+"4.freshers");
		
		
		System.out.println("======================== 1 =======================");
		List<Candidate> indorecan = repo.getAllCandidates().stream().filter((can) -> can.getCity()
																				.equals("Indore")).collect(Collectors.toList());
			
		System.out.println("======================== 2 =======================");
		
		Map<String, List<Candidate>> canCount = repo.getAllCandidates().stream().collect(Collectors
																		.groupingBy((can) -> can.getCity()));
		for(String city : canCount.keySet())
		{
			System.out.println(city+" "+canCount.get(city).size());
		}
			
		System.out.println("======================== 3 =======================");
		Map<String, List<Candidate>> canCount1 = repo.getAllCandidates().stream().collect(Collectors
																		.groupingBy((can) -> can.getTechnicl_expertise()));
		for(String tec : canCount1.keySet())
		{
			System.out.println(tec+" "+canCount1.get(tec).size());
		}
		
		System.out.println("======================== 4 =======================");
		List<Candidate> fresher = repo.getAllCandidates().stream().filter((c) -> c.getYears_of_experience()==0)
																		.collect(Collectors.toList());
		for(Candidate c : fresher)
		{
			System.out.println(c);
		}
		
		System.out.println("===============================================");
		System.out.println("List of highest experience");
		int maxExp = repo.getAllCandidates().stream().map((can) -> can.getYears_of_experience())
														.max(Integer :: compare).get();
		
		List<Candidate> senior = repo.getAllCandidates().stream().filter((c) -> c.getYears_of_experience()==maxExp)
														.collect(Collectors.toList());
		for(Candidate c:senior)
		{
			System.out.println(c);
		}
		
		System.out.println("===============================================");
		System.out.println("List of lowest experience");
		int minExp = repo.getAllCandidates().stream().map((can) -> can.getYears_of_experience())
														.min(Integer :: compare).get();
		
		List<Candidate> junior = repo.getAllCandidates().stream().filter((c) -> c.getYears_of_experience()==minExp)
														.collect(Collectors.toList());
		for(Candidate c:junior)
		{
			System.out.println(c);
		}
	}

}
