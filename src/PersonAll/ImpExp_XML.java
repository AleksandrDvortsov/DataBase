package PersonAll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ImpExp_XML implements ImportExport
{
	ArrayList<Person> pp = null;
	File f = null;
	
	public ImpExp_XML( ArrayList<Person> pp, File f ) 
	{
		this.pp = pp;
		this.f = f;
	}

	@Override
	public ArrayList<Person> load() 
	{
		ArrayList<Person > pp = new ArrayList<Person>();
		Person tmp = new Person();
		String str;
		try 
		{
			FileReader xz = new FileReader(f);
			BufferedReader bfr = new BufferedReader(xz);

			while (( str = bfr.readLine()) != null ) 
			{
				String[] st = str.split(" ");
				for ( int i = 1; i < st.length; i++)
				{
					switch (st[i]) 
					{
					case "id:":
						tmp = new Person();
						tmp.id = Integer.parseInt(st[++i]);
						break;
					case "fname:":
						tmp.fname = st[++i];
						break;
					case "lname:":
						tmp.lname = st[++i];
						break;
					case "age:":
						tmp.age = Integer.parseInt(st[++i]);
						pp.add(tmp);
						break;
					}
				}
			}
			bfr.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		return pp;
	}

	@Override
	public void save() 
	{
		String s = toString(pp);
		write(s);
	}

	private void write(String s) 
	{
		FileOutputStream fos;
		try
		{
			fos = new FileOutputStream(f);
			OutputStreamWriter osr = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osr);
			bw.write(s);
			bw.flush();
			bw.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String toString(ArrayList<Person> pp) 
	{
		String s = "<?xml version = \"1.0\"?> " + "\n" + "<Persons>" + "\n" 
				+ "<Person>" + "\n" + "Person:" + "\n";
		for ( Person p:pp )
		{
			s += "<id> id: " + p.id + " </id>" + "\n" 
					+ "<fname> fname: " + p.fname + " </fname>" + "\n"
					+ "<lname> lname: " + p.lname + " </lname>" + "\n"
					+ "<age> age: " + p.age + " </age>" + "\n" + "\n";
		}
		s += "</Person>" + "\n" + "</Persons>";
		return s;
	}

}
