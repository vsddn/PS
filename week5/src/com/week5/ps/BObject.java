package com.week5.ps;
import java.util.*;


class SortByName implements Comparator<BObject>{

	@Override
	public int compare(BObject o1, BObject o2) {
		
		return o1.name.compareTo(o2.name); 
	}
	
}

class StudentNotFound extends Exception{
	public StudentNotFound(String ex) {
		super(ex);
	}
}

class SortByCity implements Comparator<BObject>{

	@Override
	public int compare(BObject o1, BObject o2) {
		return o1.city.compareTo(o2.city);
	}
	
}

public class BObject {
	private static final int Comparator = 0;
	int id;
	String name,city;
	Scanner sc = new Scanner(System.in);
	List<BObject> arr = new ArrayList<BObject>();
	
	public void readStudents(int num) {
		while(num>0) {
		BObject obj = new BObject();
		System.out.println("Enter the student id: ");
		obj.id = sc.nextInt();
		System.out.println("Enter the name of the student: ");
		obj.name = sc.next();
		System.out.println("Enter the current city of the student: ");
		obj.city = sc.next();
		arr.add(obj);
		num--;
		}
	}
	
	public void displayStudents() {
		for(BObject student: arr) {
		System.out.println("Id: "+student.id+"\n"+
				"Name: "+student.name+"\n"+
				"City: "+student.city);
		}
	}
	
	public void displayCityStudents(String city) {
		for(BObject student :arr) {
			if(student.city.equals(city)) {
				System.out.println("Id: "+student.id+"\n"+
						"Name: "+student.name+"\n"+
						"City: "+student.city);
			}
		}
	}
	
	public void nameWiseSorted() {
		Collections.sort(arr,new SortByName());
		displayStudents();
	}
	
	public void cityWiseSorted() {
		Collections.sort(arr,new SortByCity());
		displayStudents();
	}
	
	public void studentId(int id) throws StudentNotFound {
		try {Boolean flag=false;
			for(BObject student :arr) {
				if(student.id == id) { flag=true;
					System.out.println("Id: "+student.id+"\n"+
							"Name: "+student.name+"\n"+
							"City: "+student.city);
				}
			}
			if(!flag) throw new Exception();
		} catch (Exception e) {
			throw new StudentNotFound("Student not found");
		}
	}
	
	

}
