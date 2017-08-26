import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Get defined 1. word size of the computer; 2. bus size; 3. ALU functionality;
 * 			   4. number of general registers 5. stack_pointer
 * 
 */
public class Configuration<E>{
	File file;
	Scanner sc, sc2;
	RegisterFiles registerFile;
	
	int word_size;
	int bus_size;
	int number_of_general_registers;
	int stack_pointer;
	boolean add = false;
	boolean minus = false;
	boolean multipy = false;
	boolean divide = false;
	boolean and = false;
	boolean or = false;
	boolean not = false;
	boolean xor = false;
	
	//constructor of Configuration
	public Configuration(File config_file, RegisterFiles registerFile) {
		file = config_file;
		this.registerFile = registerFile;
	}
	
	/**
	 * Scan the file to get word size, bus size, alu functionality, stack pointer location and 
	 * number of general registers
	 */
	public void scanFile(){
		try{
			sc = new Scanner(file);
			while(sc.hasNextLine()){
				sc2 = new Scanner(sc.nextLine());
				while(sc2.hasNext()){
					String temp = sc2.next();
					if(temp.equals("word_size")){
						word_size = sc2.nextInt();
					}
					else if(temp.equals("bus_size")){
						bus_size = sc2.nextInt();
					}
					else if(temp.equals("number_of_general_registers")){
						number_of_general_registers = sc2.nextInt();
						for(int i = 0; i < number_of_general_registers; i++){
							String register_name = sc2.next();
							String binary_reg = sc2.next();
							GeneralRegister<E> register = new GeneralRegister<>();
							register.set_name(register_name);
							registerFile.insert(binary_reg, register);
							registerFile.addName(register_name);
							registerFile.addBinary(binary_reg);
						}
					}
					else if(temp.equals("ALU_Functionality")){
						while(sc2.hasNext()){
							String command = sc2.next();
							String function = sc2.next();
							if(command.equals("add:") && function.equals("true")){
								add = true;
							}
							else if(command.equals("minus:") && function.equals("true")){
								minus = true;
							}
							else if(command.equals("multipy:") && function.equals("true")){
								multipy = true;
							}
							else if(command.equals("divide:") && function.equals("true")){
								divide = true;
							}
							else if(command.equals("and:") && function.equals("true")){
								and = true;
							}
							else if(command.equals("or:") && function.equals("true")){
								or = true;
							}
							else if(command.equals("not:") && function.equals("true")){
								not = true;
							}
							else if(command.equals("xor:") && function.equals("true")){
								xor = true;
							}
						}
					}
					else if (temp.equals("stack_pointer")) {
						stack_pointer = sc2.nextInt();
					}
				}
			}
		}
		catch(FileNotFoundException e){
			 e.printStackTrace();
		}
	}
	
	/**
	 * get word size which has been set up
	 * @return word size
	 */	
	public int getWord_size(){
		return word_size;
	}
	
	/**
	 * get bus size which has been set up
	 * @return bus size
	 */	
	public int getBus_size(){
		return bus_size;
	}

	/**
	 * get number_of_general_registers which has been set up
	 * @return number_of_general_registers
	 */	
	public int getNumber_of_general_registers(){
		return number_of_general_registers;
	}
	
	/**
	 * Determine whether 'add' function works
	 * @return add
	 */	
	public boolean alu_add(){
		return add;
	}
	
	/**
	 * Determine whether 'minus' function works
	 * @return minus
	 */	
	public boolean alu_minus() {
		return minus;
	}
	
	/**
	 * Determine whether 'multipy' function works
	 * @return multipy
	 */	
	public boolean alu_multipy() {
		return multipy;
	}
	
	/**
	 * Determine whether 'divide' function works
	 * @return divide
	 */	
	public boolean alu_divide() {
		return divide;
	}
	
	/**
	 * Determine whether 'and' function works
	 * @return and
	 */	
	public boolean alu_and() {
		return and;
	}
	
	/**
	 * Determine whether 'or' function works
	 * @return or
	 */	
	public boolean alu_or() {
		return or;
	}
	
	/**
	 * Determine whether 'not' function works
	 * @return not
	 */	
	public boolean alu_not() {
		return not;
	}
	
	/**
	 * Determine whether 'xor' function works
	 * @return xor
	 */	
	public boolean alu_xor() {
		return xor;
	}
	
	/**
	 * Get the stack pointer initial location
	 * @return stack_pointer
	 */	
	public int getStackPoint(){
		return stack_pointer;
	}
}
