package db;
import utn.frd.bean.*;
import java.util.ArrayList;
import java.util.List;

public class PersistentManager {
	private static List<Persona> data = new ArrayList<Persona>();
	
	public static List<Persona> getInstance(){
		return data;
	}

}
