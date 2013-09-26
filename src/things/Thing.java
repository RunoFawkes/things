package things;

import java.util.ArrayList;

import creators.ThingCreator;

/**
 * Classe responsavel pelas coisas. literalmente.
 * 
 * @author Gabriel
 *
 */
public class Thing {
	
	//seed da coisa
	double seed = 0;
	//seed da coisa
	String id = "";
	//o que ela e (seus atributos)
	ArrayList<Atribute> is = new ArrayList<Atribute>();
	//o que ela tem
	ArrayList<Thing> has = new ArrayList<Thing>();
	//criador de coisas
	ThingCreator creator;

	//=========================
	//CONSTRUTORES
	//=========================


	/**
	 * Construtor com id e seed definido
	 * 
	 * @param id
	 * @param pSeed
	 */
	public Thing(String pId, double pSeed) {
		this.id = pId;
		this.seed = pSeed;
		this.creator = new ThingCreator(this.id,this.seed);
	}
	
	//=========================
	//metodos
	//=========================

	/**
	 * Defide o objeto, detalhandoo mais
	 * 
	 */
	public void define() {
		this.is = this.creator.defineIs();
		this.has = this.creator.defineHas();
	}
	
	
	//==========================
	//getters
	//==========================
	
	/**
	 * Retorna o que o objeto e (seus atributos)
	 * @return
	 */
	public ArrayList<Atribute> getIs(){
		return this.is;
	}
	
	public ArrayList<Thing> getHas(){
		return this.has;
	}
	
	public String getId(){
		return this.id;
	}
	
	public double getSeed(){
		return this.seed;
	}

}
