/**
 * ALU functionalities may contain: Add, Minus, Multipy, Divide, And, Or, Not
 */
public class ALU {
	boolean add;
	boolean minus;
	boolean multipy;
	boolean divide;
	boolean and;
	boolean or;
	boolean not;
	boolean xor;
	
	//constructor
	public ALU(boolean add, boolean minus, boolean multipy, boolean divide, boolean and, boolean or, boolean not, boolean xor){
		this.add = add;
		this.minus = minus;
		this.multipy = multipy;
		this.divide = divide;
		this.and = and;
		this.or = or;
		this.not = not;
		this.xor = xor;
	}
	
	/**
	 * Functionality: add
	 * @param x, y
	 * @return if functionality is true,x+y ; else, -1
	 */	
	public int add(int x, int y) {
		if(add == true){
			return x+y;
		}
		else {
			System.out.println("ERROR: No Add Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: minus
	 * @param x, y
	 * @return if functionality is true,y-x ; else, -1
	 */	
	public int minus(int x, int y) {
		if(minus == true){
			return y - x;
		}
		else {
			System.out.println("ERROR: No minus Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: multiply
	 * @param x, y
	 * @return if functionality is true,y*x ; else, -1
	 */	
	public int multipy(int x, int y) {
		if(multipy == true){
			return y*x;
		}
		else {
			System.out.println("ERROR: No multipy Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: divide
	 * @param x, y
	 * @return if functionality is true,y/x ; else, -1
	 */	
	public int divide(int x, int y) {
		if(divide == true){
			return y/x;
		}
		else {
			System.out.println("ERROR: No divide Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: and
	 * @param x, y
	 * @return if functionality is true,y&x ; else, -1
	 */	
	public int and(int x, int y) {
		if(and == true){
			return y&x;
		}
		else {
			System.out.println("ERROR: No and Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: or
	 * @param x, y
	 * @return if functionality is true,y|x ; else, -1
	 */	
	public int or(int x, int y) {
		if(or == true){
			return y|x;
		}
		else {
			System.out.println("ERROR: No or Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: not
	 * @param x
	 * @return if functionality is true,~x ; else, -1
	 */	
	public int not(int x) {
		if(or == true){
			return ~x;
		}
		else {
			System.out.println("ERROR: No or Functionality");
			return -1;
		}
	}
	
	/**
	 * Functionality: xor
	 * @param x
	 * @return if functionality is true,x^y ; else, -1
	 */	
	public int xor(int x, int y) {
		if(or == true){
			return x^y;
		}
		else {
			System.out.println("ERROR: No or Functionality");
			return -1;
		}
	}
}
