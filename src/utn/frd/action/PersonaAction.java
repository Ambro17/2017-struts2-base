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
		if ( ! existe(id, personas)){
			personas.add(new Persona(name, edad, gender));
			// TODO revisar metodo existe, problema con ID
		}
		else {
			Persona pers = buscarPersona(id, personas);
			modificarPersona(pers);
		}
		// para tomar los valores nuevos del formulario.
		resetForm();
		
		return SUCCESS;
	}
	
	public String modify(){
		// recibo el id desde el action, personas.jsp>struts.xml>paction.java
		personas = PersistentManager.getInstance();
		Persona persona = buscarPersona(id,personas);
		id = persona.getId();
		name = persona.getName();
		age = String.valueOf(persona.getAge());
		gender = persona.getGender();
		
		return SUCCESS;
	}
	public String delete(){
		List<Persona> personas = PersistentManager.getInstance();
		personas.removeIf(persona-> persona.getId() == id);
		return SUCCESS;
	}

	private boolean existe(long id, List<Persona> personas){
		return personas.stream().anyMatch(p->p.getId() == id);
	}
	private Persona buscarPersona(long id, List<Persona> personas){
		Persona foundPersona=null;
		for (Persona ps : personas){
			if (ps.getId() == id) {
				foundPersona = ps;
			}
		}
		return foundPersona;
	}
	private void modificarPersona(Persona pers){
		pers.setName(name);
		pers.setAge(Integer.parseInt(age));
		pers.setGender(gender);
	}
	private void resetForm(){
		id = -1;
		name="";
		age="";
		gender="";
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
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}	
}
