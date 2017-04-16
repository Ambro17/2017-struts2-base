package utn.frd.bean;

/* Esta es una clase normal, en java se lo llama "bean"
 * Hereda de Object, tiene campos, los accesors y los constructores */
public class MessageStore {
	private String message;

	public MessageStore(String message) {
		setMessage(message);
		System.out.println(message);
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}
}
