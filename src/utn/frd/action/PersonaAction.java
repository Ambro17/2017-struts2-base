package utn.frd.action;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import db.PersistentManager;
import utn.frd.bean.*;
public class PersonaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String age;
	private String gender;
	private List<Persona> personas;
	
	public String execute(){
		personas = PersistentManager.getInstance();
		
		return SUCCESS;
	}

	public String save(){
		personas = PersistentManager.getInstance();
		int edad = 0;
		try{
			edad = Integer.parseInt(age);
		} catch(Exception e){
			addActionError("Ocurrió un error con la edad");
			return ERROR;
		}
		
		//Si el id existe, modificar. Sino agregar una nueva persona
		personas.add(new Persona(name, edad, gender));

		return SUCCESS;
	}

	
	
	// GETTERS AND SETTERS //
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
