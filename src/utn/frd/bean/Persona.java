package utn.frd.bean;

public class Persona {
	private static long idTabla=0; //static lo hace inmune al reseteo en la instanciacion
	private long id;
	private String name;
	private int age;
	private String gender;
	public Persona(String name, int age, String gender) {
		this.id = miId();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	private long miId(){
		return idTabla++;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
