import java.util.ArrayList;

public class MemoryData<E> {
	E value = (E)"Null";
	public void set_value(E num){
		value = num;
	}
	
	public E get_value(){
		return value;
	}
}
