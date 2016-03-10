import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


//Extend this later using HashSets and multiple arrays to include multiple states and majors
public class Gradebook {
	static ArrayList <String> names = new ArrayList<String>();
	static ArrayList <String> grades = new ArrayList<String>();
	static ArrayList <String> genders = new ArrayList<String>();
	static ArrayList <String> majors = new ArrayList<String>();
	static ArrayList <String> statesOfOrigin = new ArrayList<String>();
	static ArrayList <Double> scores = new ArrayList<Double>();
	public static void main( String[] args )
	{
		boolean loopEnd = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to enter student? yes/no");
		String choice = sc.next();
		if(choice.equals("yes"))
		{
			while(loopEnd)
			{
				System.out.println("How many records do you want to input?");
				int noOfRecords = sc.nextInt();
				for(int i=0;i<noOfRecords;i++)
				{
					getInfo(sc);
					showReport(false);
				}
				System.out.println("Do you want to add more records?");
				String yesOrNo = sc.next();
				if(yesOrNo=="no")
				{
					loopEnd=false;
				}

			}
		}
		showReport(true);
		sc.close();
	}
	
	public static void getInfo(Scanner sc)
	{
		System.out.println("Please enter the student's info");
		System.out.print("Please enter the student's name: ");
		String name = sc.next();
		System.out.print("Please enter the student's grade: ");
		String grade = sc.next();
		System.out.print("Please enter the student's gender: ");
		String gender = sc.next();
		System.out.print("Please enter the student's major: ");
		String major = sc.next();
		System.out.print("Please enter the student's state of origin: ");
		String stateOfOrigin = sc.next();
		System.out.print("Please enter the student's score: ");
		double score = sc.nextDouble();
		names.add(name);grades.add(grade);genders.add(gender);majors.add(major);statesOfOrigin.add(stateOfOrigin);scores.add(score);
	}
	
	public static void showReport(boolean end)
	{
		if(end)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println("Report Date: "+dateFormat.format(date));
		}
		int noOfStudents = names.size();
		double average = average(scores);
		System.out.println("Number of Students: "+noOfStudents);
		System.out.println("OverallAverage: "+average);
		averageByGender();
		averageByMajor();
		averageByState();
		

	}
	
	public static double average(ArrayList<Double> avg)
	{
		double average = 0;
		for(int i =0;i<avg.size();i++)
		{
			average+=avg.get(i);
		}
		return average/avg.size();
	}
	
	public static void averageByGender()
	{
		double averageM=0, averageF=0;
		double countM=0, countF=0;
		
		for(int i =0; i<genders.size();i++)
		{
			if(genders.get(i).equalsIgnoreCase("M"))
			{
				averageM+=scores.get(i);
				countM++;
			}
			else if(genders.get(i).equalsIgnoreCase("F"))
			{
				averageF+=scores.get(i);
				countF++;
			}
			

		}
		if(countM==0)countM=1;
		if(countF==0)countF=1;
		System.out.println("Average scores for males: "+(averageM/countM));
		System.out.println("Average scores for females: "+(averageF/countF));
	}
	
	public static void averageByMajor()
	{
		double averageM=0, averageF=0, averageA=0;
		double countM=0, countF=0, countA=0;
		
		for(int i =0; i<genders.size();i++)
		{
			if(majors.get(i).equalsIgnoreCase("Math"))
			{
				averageM+=scores.get(i);
				countM++;
			}
			else if(majors.get(i).equalsIgnoreCase("Finance"))
			{
				averageF+=scores.get(i);
				countF++;
			}
			else if(majors.get(i).equalsIgnoreCase("Arts"))
			{
				averageA+=scores.get(i);
				countA++;
			}
			
		}
		if(countM==0)countM=1;
		if(countF==0)countF=1;
		if(countA==0)countA=1;
		System.out.println("Average scores for Math: "+(averageM/countM));
		System.out.println("Average scores for Finance: "+(averageF/countF));
		System.out.println("Average scores for Arts: "+(averageA/countA));
	}
	
	public static void averageByState()
	{
		double averageM=0, averageV=0, averageD=0;
		double countM=0, countV=0, countD=0;
		
		for(int i =0; i<genders.size();i++)
		{
			if(statesOfOrigin.get(i).equalsIgnoreCase("Maryland"))
			{
				averageM+=scores.get(i);
				countM++;
			}
			else if(statesOfOrigin.get(i).equalsIgnoreCase("Virginia"))
			{
				averageV+=scores.get(i);
				countV++;
			}
			else if(statesOfOrigin.get(i).equalsIgnoreCase("DC"))
			{
				averageD+=scores.get(i);
				countD++;
			}
			
		}
		if(countM==0)countM=1;
		if(countV==0)countV=1;
		if(countD==0)countD=1;
		System.out.println("Average scores for Maryland: "+(averageM/countM));
		System.out.println("Average scores for Virginia: "+(averageV/countV));
		System.out.println("Average scores for DC: "+(averageD/countD));
	}
}
