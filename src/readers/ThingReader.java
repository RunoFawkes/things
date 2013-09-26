package readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import things.Atribute;


/**
 * Le .thing e retorna suas informacoes.
 * 
 * @author Gabriel
 *
 */
public class ThingReader {

	BufferedReader dotThing;
	String addres = "." + File.separator + "data" + File.separator + "things" + File.separator;

	public ThingReader(String pId) {
		try {
			
			this.dotThing = new BufferedReader(new FileReader(this.addres + pId + ".thing"));
			
			try {
				if((this.dotThing.readLine().equals("[THING@"+pId+"]"))==false){
						System.out.println("Arquivo nao [THING]!");
						this.dotThing=null;
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Atribute> defineIs() {
		String line = "";
		ArrayList<Atribute> is = new ArrayList<Atribute>();
		try {
			line = this.dotThing.readLine();
			if(line.equals("is{")){
				while (line.equals("}")==false) {
					line = this.dotThing.readLine();
					if(line.charAt(0)=='['){
						line = line.replace("[", "").replace("]", "");
						String[] tempVal = line.split("::");
						
						if(tempVal.length==3){
							is.add(new Atribute(tempVal[0],tempVal[1]+"::"+tempVal[2]));
						}else{
							is.add(new Atribute(tempVal[0],tempVal[1]));
						}
						
						
					}else if(line.charAt(0)=='N'){
						is = null;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	public ArrayList<String> defineHas() {
		String line;
		ArrayList<String> tempList = new ArrayList<String>();
		try {
			line = this.dotThing.readLine();
			
			if(line.equals("has{")){
				line = this.dotThing.readLine();
				while(line.equals("}")==false){
					tempList.add(line);
					line = this.dotThing.readLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempList;
	}
	


}
