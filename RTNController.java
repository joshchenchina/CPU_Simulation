import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class RTNController {
	ArrayList<ArrayList<String>> rtnTemplate = new ArrayList<ArrayList<String>>();
	File rtnFile;
	Scanner scanner;
	private ArrayList<String> rtnList = new ArrayList<String>();
	public RTNController(File file){
		rtnFile = file;
	}
	
	public void scanFile(){
		try {
			scanner = new Scanner(rtnFile);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				rtnList.add(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void setRTNTemplate(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < rtnList.size(); i++){
			//Check all lines with ":"
			if(regexChecker("(\\:+)", rtnList.get(i)) == true){
				temp.add(i);
			}
		}
		int j= 0; int k = 1;
		while(j < temp.size() - 1){
			ArrayList<String> temp2 = new ArrayList<String>();
				for(int x = temp.get(j); x < temp.get(k); x++){
					temp2.add(rtnList.get(x));
				}
				rtnTemplate.add(temp2);
				j++;
				k++;
		}
		
	}
	
	public boolean regexChecker(String theRegex, String str2check){
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2check);
		while(regexMatcher.find()){
			if (regexMatcher.group().length() != 0) {
				return true;
			}
			return false;
		}
		return false;
	}

}
