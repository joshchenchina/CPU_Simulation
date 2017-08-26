import java.io.File;
import java.util.ArrayList;

/**
 * Control Unit of the CPU, Contain the RTN List
 * Run Fetch-Exec Cycle
 */
public class ControlUnit {
	int i = 0;
	DataPath dataPath;
	File rtnFile = new File("RTN_file.txt");
	RTNController rController;
	
	public ControlUnit(DataPath dp) {
		dataPath = dp;
		//Read RTN File and Create a lookup list 
		rController = new RTNController(rtnFile);
		rController.scanFile();
		rController.setRTNTemplate();
		
		//Run Fetch-Exec Cycle
		//Keep run Fetch unless there is a 'halt'
		while(dataPath.programCounter.get_value() < dataPath.mainMemory.mainM.size()){
			this.fetch((dataPath.programCounter.get_value()));
		}
		System.out.println("Finish");
			
		
	}
	
	//Fetch
	public void fetch(int key){
		System.out.println("Fetch: MA <- PC; C <- PC +1; PC <- C; IR <- MD");
		//MA <- PC
		dataPath.programCounter.set_value(key);
		dataPath.memoryAddress.set_value((Integer)dataPath.programCounter.get_value());
		
		//C <- PC +1
		dataPath.c.set_value(dataPath.alu.add((Integer)dataPath.programCounter.get_value(), 1));
		
		//MD <- M[MA]
		dataPath.memoryData.set_value(dataPath.mainMemory.getMemory(dataPath.memoryAddress
				.get_value()));
		
		//PC <- C
		dataPath.programCounter.set_value((Integer)dataPath.c.get_value());
		
		//IR <- MD
		dataPath.getIR((ArrayList)dataPath.memoryData.get_value());
		
	}
}
