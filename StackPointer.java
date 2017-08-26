
public class StackPointer<E> {
	E value = (E)"Null";
	String flag;
	public void set_value(E num){
		value = num;
	}
	
	public E get_value(){
		return value;
	}
}
