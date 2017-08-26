/**
 * CPU simulator, control the simulation, contains ControlUnit and DataPath
 */
public class CPUsimulator {
	DataPath dataPath;
	ControlUnit controlUnit;
	
	//constructor
	public CPUsimulator() {
		dataPath = new DataPath();
		controlUnit = new ControlUnit(dataPath);
	}
}
