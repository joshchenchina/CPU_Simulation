import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UnitTest {

	@Test
	public void test_irmov() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("0");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(0, Integer.parseInt(iRegisters.irmov().toString()));
	}
	
	@Test
	public void test_rrmov() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals("Null", iRegisters.rrmov().toString());
	} 
	
	@Test
	public void test_add() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(11, iRegisters.add());
	} 
	
	@Test
	public void test_sub() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(9, iRegisters.minus());
	} 

	@Test
	public void test_multiply() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(10, iRegisters.multiply());
	} 
	
	@Test
	public void test_divide() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(10, iRegisters.divide());
	} 
	
	@Test
	public void test_xor() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(11, iRegisters.xor());
	} 
	
	@Test
	public void test_or() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(11, iRegisters.or());
	} 
	
	@Test
	public void test_and() {
		GeneralRegister r1 = new GeneralRegister();
		GeneralRegister r2 = new GeneralRegister();
		r1.store("0");
		r2.store("1");
		ArrayList input = new ArrayList();
		input.add("011");
		input.add("010");
		input.add("000001");
		input.add("00");
		ALU alu = new ALU(true, true, true, true, true, true, true, true);
		A a = new A();
		C c = new C();
		MemoryAddress mAddress = new MemoryAddress();
		MemoryData mData = new MemoryData();
		MainMemory mainMemory = new MainMemory();
		RegisterFiles registerFiles = new RegisterFiles();
		registerFiles.insert("011", r1);
		registerFiles.insert("010", r2);
		mainMemory.insert(011, input);
		mainMemory.insert(010, input);
		InstructionRegisters iRegisters = new InstructionRegisters(input, registerFiles, a, c, alu, mAddress, mData, mainMemory);
		assertEquals(0, iRegisters.and());
	} 
} 
