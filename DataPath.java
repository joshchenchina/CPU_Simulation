import java.io.File;
import java.util.ArrayList;
import javax.xml.transform.Templates;
/**
 * Data Path of CPU, read Configuration file
 * Data path contains:
 * 	- Main Memory: Store binary number represents opcodes
 *	- Program Counter(PC): Tell the location of the next instruction
 * 	- Instruction Registers(IR): Tell the controller what the instructor is doing Link to the controller
 * 	- Stack Pointer(SP): Tell where in the stack you are
 * 	- Memory Address(MA): Read from the main memory
 * 	- Memory Data(MD): Read or Write from the main memory
 * 	- A: Register
 * 	- C: Register
 * 	- ALU: computation(get functionality from Configuration File)
 * 	- Genral Registers: get information from Configuration File, store general registers in RegisterFiles
 */
public class DataPath {
	RegisterFiles registerFile;
	MainMemory mainMemory;
	Configuration configuration;
	ProgramCounter programCounter;
	InstructionRegisters instructionRegisters;
	StackPointer stackPointer;
	MemoryAddress memoryAddress;
	MemoryData memoryData;
	A a;
	C c;
	ALU alu;
	
	//constructor
	public DataPath(){
		registerFile = new RegisterFiles();
		mainMemory = new MainMemory();

		programCounter = new ProgramCounter();
		memoryAddress = new MemoryAddress();
		a = new A();
		c = new C();
		memoryData = new MemoryData();
		
		//initialize main memory
		this.initializeMainMemory();
		
		//get Configuration
		File config_file = new File("configuration.txt");
		configuration = new Configuration(config_file, registerFile);
		configuration.scanFile();
		
		//initialize Stack Pointer
		stackPointer = new StackPointer();
		stackPointer.set_value(configuration.getStackPoint());
		
		alu = new ALU(configuration.alu_add(), configuration.alu_minus(),
				configuration.alu_multipy(), configuration.alu_divide(), configuration.alu_and(), 
				configuration.alu_or(), configuration.alu_not(), configuration.alu_xor());
	}
	
	//call instruction Register
	public void getIR(ArrayList<String> temp){
		instructionRegisters = new InstructionRegisters(temp, registerFile, a, c, alu, memoryAddress, memoryData, mainMemory);
	}
	
	public void initializeMainMemory(){
		//irmovq $0, %r3
		ArrayList<String> r0 = new ArrayList<String>();
		r0.add("011");
		r0.add("0");
		r0.add("000001");
		r0.add("00");
		
		//rrmovq %r3, %r1
		ArrayList<String> r1 = new ArrayList<String>();
		r1.add("001");
		r1.add("011");
		r1.add("000010");
		r1.add("00");
		
		//rmmovq %r3, (%r1)
		ArrayList<String> r2 = new ArrayList<String>();
		r2.add("001");
		r2.add("011");
		r2.add("000011");
		r2.add("00");
		r2.add("0");
		
		mainMemory.insert(0, r0);
		mainMemory.insert(1, r1);
		mainMemory.insert(2, r2);
	}
}
