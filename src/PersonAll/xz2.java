package PersonAll;

import java.util.ArrayList;

public class xz2 {

	public static void main(String[] args) {
		PersonDAO_SQL dao = new PersonDAO_SQL();
//		Person users = new Person();
//		dao.create(users);
//		System.out.println(users);
//		dao.create(users);
		ArrayList<Person> pp = dao.read();
//		dao.read();
			System.out.print(pp);
		
	}

}
