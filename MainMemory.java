import java.lang.reflect.Array;
import java.util.*;
/**
 * Code for a memory simulator
 */
public class MainMemory {
	HashMap<Integer, ArrayList> mainM;
	//construction of InputFileParser
	public MainMemory(){
		mainM= new HashMap<Integer, ArrayList>();	
	}
	
	public void insert(int key, ArrayList values){
		mainM.put(key, values);
	}
	
	public ArrayList getMemory(int n){
		return mainM.get(n);
	}
}