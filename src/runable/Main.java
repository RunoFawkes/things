package runable;




import things.*;

import java.util.*;


//import gui.GUI;

public class Main {

	static Thing currentThing;
	
	public static void main(String[] args) {
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("- - - - - -  T H I N G S      - - - - - -");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		
		
		ini();
		analize(currentThing);
		
		while(true){
			enter();
			System.out.println("========================================");
			System.out.println("========================================");
			System.out.println("========================================");
			System.out.println("========================================");
			analize(currentThing);
		}
		
		
		
		
		
	
	}
	
	public static void ini(){
		System.out.println("<> Criando Algo!");
		currentThing = new Thing("testting",42);
		System.out.println("<> Algo Criado!");
		currentThing.define();
	}
	
	@SuppressWarnings("resource")
	public static void enter(){
		Scanner s;
		s = new Scanner(System.in);
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("<> Entre com o Index \nda coisa que deseja examinar.");
		int i = 0;
		i = s.nextInt();
		currentThing = currentThing.getHas().get(i);
		currentThing.define();
		//s.close();
	}
	
	public static void analize(Thing thing){
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("<> ID: "+thing.getId()+"\nSua Seed e: "+thing.getSeed());
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("<> Seus Atributos:");
		for(Atribute a:thing.getIs()){
			System.out.println("<> "+a.getName()+" : "+a.getValue());
		}
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("<> Isso Tem "+thing.getHas().size()+" Coisas:");
		int c = 0;
		for(Thing t:thing.getHas()){
			
			System.out.println("- - - -");
			System.out.println("<"+c+"> ID: "+t.getId()+"\nSeed: "+t.getSeed());
			c++;
		}
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		
	}
	


}
