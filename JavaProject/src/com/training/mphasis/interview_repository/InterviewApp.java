package com.training.mphasis.interview_repository;
import java.util.*;
public class InterviewApp {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our app");
		System.out.println("Enter your choice");
		InterviewRepository repository = new InterviewRepository();
		
		do {
			System.out.println("1.Add Candidate\n2.Remove Candidate\n3.View Candidate\n4.View All\n5.exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1 :	System.out.println("Enter name, technical expertise, city and years of experience");
						repository.addCandidate(new Candidate(sc.next(), sc.next(), sc.next(), sc.nextInt()));
						System.out.println("Candidate added");
						break;
					
			case 2 :	System.out.println("Enter the index");
						repository.deleteCandidate(sc.nextInt());
						System.out.println("Candidate deleted");
						break;
					
			case 3 :	System.out.println("Enter the index");
						Candidate c1 = repository.getCandidate(sc.nextInt());
						System.out.println(c1.getName()+" "+c1.getTechnicl_expertise()+" "+c1.getCity()
																+" "+c1.getYears_of_experience());
						break;
					
			case 4 :	System.out.println("List of candidates");
						List<Candidate> cans = repository.getAllCandidates();
						cans.forEach((c) -> System.out.println(c.getName()+" "+c.getTechnicl_expertise()
																+" "+c.getCity()+" "+c.getYears_of_experience()));
						break;
					
			case 5 :	System.out.println("Thank you");
						System.exit(0);
						break;
						
			default : 	System.out.println("Invalid choice");
			}
		}while(true);
	}
	

}
