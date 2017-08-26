import java.util.ArrayList;
import java.util.HashMap;

/**
 * Store all General Register
 */
public class RegisterFiles {
	//key: binary representation of general register; value: general register
	HashMap<String, GeneralRegister> registerList;
	
	ArrayList<String> namelist;
	ArrayList<String> binarylist;
	
	//constructor
	public RegisterFiles(){
		registerList = new HashMap<String, GeneralRegister>();
		namelist = new ArrayList<String>();
		binarylist = new ArrayList<String>();
	}
	
	/**
	 * insert into registerList
	 * @param name of register, Register
	 */
	public void insert(String name, GeneralRegister reg){
		registerList.put(name, reg);
	}
	
	/**
	 * Get register from register list by name of register
	 * @param name of register
	 * @return Register
	 */
	public GeneralRegister getRegister(String key){
		return registerList.get(key);
	}
	
	/**
	 * add name of register into name list
	 * @param name of register
	 */
	public void addName(String name){
		namelist.add(name);
	}
	
	/**
	 * add binary representation of register into binary list
	 * @param name of register
	 */
	public void addBinary(String bi){
		binarylist.add(bi);
	}

	/**
	 * get register's storage by register name from register list
	 * @param name of register
	 */
	public Object getValue(String key){
		return registerList.get(key).load();
	}
	
	/**
	 * get binary representation of register from binary list
	 * @param int number
	 */
	public String getBinary(int n) {
		return binarylist.get(n);
		
	}
}
