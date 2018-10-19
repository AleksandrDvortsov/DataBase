package PersonAll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ImpExp_YAML implements ImportExport
{
	ArrayList<Person> pp = null;
	File f = null;

	public ImpExp_YAML ( ArrayList<Person> pp, File f )
	{
		this.pp = pp;
		this.f = f;
	}
	@Override
	public ArrayList<Person> load() 
	{
		Person tmp = null;
		String str = null;
		ArrayList<Person> pp = new ArrayList<Person>();

		try 
		{
			FileReader xz = new FileReader(f);
			BufferedReader bfr = new BufferedReader(xz);
			while (( str = bfr.readLine()) != null )
			{
				String[] st = str.split(" ");
				for ( int i = 1; i < st.length; i++ )
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
	private String toString(ArrayList<Person> pp) 
	{
		String s = "Person:" + "\n";
		for ( Person p:pp )
		{
			s += "- id: " + p.id + "\n" 
					+ "- fname: " + p.fname + "\n"
					+ "- lname: " + p.lname + "\n"
					+ "- age: " + p.age + "\n";
		}
		return s;
	}
	private void write(String s) 
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osr = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osr);
			bw.write(s);
			bw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
