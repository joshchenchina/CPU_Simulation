import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.lang.model.element.Element;

/**
 *  Format - 
 *  3 bits: destination, 3 bits: source, 6 bits different instruction, 2 bits size, n bits other
 */
public class InstructionRegisters {
	A a1;
	C c1;
	ALU alu;
	MemoryAddress mAddress;
	MemoryData mData;
	ArrayList<String> temp;
	RegisterFiles registerFiles;
	MainMemory mainMemory;
	public InstructionRegisters(ArrayList<String> input, RegisterFiles registerFiles, A a, C c,
			ALU aLu, MemoryAddress ma, MemoryData md, MainMemory Mm){
		temp = input;
		this.registerFiles = registerFiles;
		a1 = a;
		c1 = c;
		mData = md;
		mAddress = ma;
		alu = aLu;
		mainMemory = Mm;
		this.decode();
		
	}
	
	//these are learned from the RTN Template
	public void decode(){
		//irmov
		if(temp.get(2).equals("000001")){
			this.irmov();
		}
		//rrmov
		else if(temp.get(2).equals("000010")){
			this.rrmov();
		}
		//mrmov
		else if(temp.get(2).equals("000100")){
			this.mrmov();
		}
		//rmmov
		else if(temp.get(2).equals("000011")){
			this.rmmov();
		}
		//add
		else if(temp.get(2).equals("001101")){
			this.add();
		}
		//sub
		else if(temp.get(2).equals("001110")){
			this.minus();
		}
		//and
		else if(temp.get(2).equals("001100")){
			this.and();
		}
		//xor
		else if(temp.get(2).equals("001111")){
			this.xor();
		}
		
		
	}
	public Object irmov(){
		//R[dest] <- Imm
		String imm = temp.get(1);
		String dest = temp.get(0);
		
		//store imm value into general register
		registerFiles.getRegister(dest).store(imm);
		System.out.println("irmov: R["+dest+"] <-"+ imm);
		return registerFiles.getValue(dest);
	}
	
	public Object rrmov(){
		//R[dest] <- R[src]
		String dest = temp.get(0);
		String src = temp.get(1);
		
		//store Register of src into Register of dest
		registerFiles.getRegister(dest).store(registerFiles.getValue(src));
		System.out.println("rrmov: R[" + dest + "] <- R[" +src + "]");
		return registerFiles.getValue(dest);
	}
	
	public Object rmmov(){
		//A <- R[dest]
		String dest = temp.get(0);
		String dest_value = (String)registerFiles.getValue(dest);
		a1.set_value(dest_value);
		//C <- A + Imm
		String imm = temp.get(4);
		c1.set_value(alu.add(Integer.valueOf((String)a1.get_value()), Integer.valueOf(imm)));
		//MA <- C
		mAddress.set_value(Integer.parseInt(c1.get_value().toString()));
		//MD <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		mData.set_value(Integer.valueOf(src_value));
		//M[MA] <- MD
		ArrayList temp = new ArrayList();
		temp.add(mData.get_value());
		mainMemory.insert(mAddress.get_value(), temp);
		System.out.println("rmmov: A <- R[" + dest + "]; C <- A + " + imm + "; MA <- C; MD <- R[" + src + "]; M["+ mData.get_value() +"] <- MD");
		return registerFiles.getValue(dest);
	}
	
	public Object mrmov(){
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A + Imm
		String imm = temp.get(4);
		c1.set_value(alu.add(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(imm)));
		//MA <- C
		mAddress.set_value(Integer.parseInt(c1.get_value().toString()));
		//MD <- M[MA]
		mData.set_value(mainMemory.getMemory(mAddress.get_value()));
		//R[dest] <- MD
		String dest = temp.get(0);
		registerFiles.getRegister(dest).store(dest);
		System.out.println("mrrmov: A <- R[" + src + "]; C <- A + " + imm + "; MA <- C; MD <- M[" +mAddress.get_value() +"]; R[" + dest +"] <- MD");
		return registerFiles.getValue(dest);
	}
	
	public Object add(){
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A + R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.add(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A + R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
	
	public Object minus() {
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A - R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.minus(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A - R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
	
	public Object multiply() {
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A * R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.multipy(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A * R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
	
	public Object divide() {
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A / R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.divide(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A / R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
	
	public Object and() {
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A & R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.and(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A & R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
	
	public Object or() {
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A | R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.or(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A | R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
	
	public Object xor() {
		//A <- R[src]
		String src = temp.get(1);
		String src_value = (String)registerFiles.getValue(src);
		a1.set_value(Integer.valueOf(src_value));
		//C <- A ^ R[dest]
		String dest = temp.get(0);
		c1.set_value(alu.xor(Integer.valueOf(a1.get_value().toString()), Integer.valueOf(registerFiles.getValue(dest).toString())));
		//R[dest] <- C
		registerFiles.getRegister(dest).store(c1.get_value());
		System.out.println("A <- R[" + src + "]; C <- A ^ R[" + dest + "]; R[" + dest + "] <- C");
		return registerFiles.getValue(dest);
	}
}
