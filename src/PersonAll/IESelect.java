package PersonAll;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

public class IESelect 
{
	public static ImportExport getIE( File file, ArrayList<Person> pp )
	{
		ImportExport ie  = null;
		
		String name = file.getName();
																////		name = name.toLowerCase(Locale.ENGLISH); - для преобразования в нижний регистр eng
		if ( name.endsWith(".json"))
		{
			ie = new ImpExp_JSON(pp, file);
		}
		else if ( name.endsWith(".xml"))
		{
			ie = new ImpExp_XML(pp, file);
		}
		else if ( name.endsWith(".csv"))
		{
			ie = new ImpExp_CSV(pp, file);
		}
		else if ( name.endsWith(".yml"))
		{
			ie = new ImpExp_YAML(pp, file);
		}
		
		else 
			JOptionPane.showMessageDialog(null, "БД null");

		return ie;
	}
}
