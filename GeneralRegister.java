import java.util.jar.Attributes.Name;

/**
 * General register class, all registers should extends this;
 */
public class GeneralRegister<E> {
	E object = (E) "Null";
	String name;
	public void store(E object){
		this.object = object;
	}
	public E load(){
		return object;
	}
	
	public void set_name(String name){
		this.name = name;
	}
	
	public String get_name(){
		return name;
	}
}