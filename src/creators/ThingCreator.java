package creators;

import java.util.ArrayList;

import readers.ThingReader;
import things.Atribute;
import things.Thing;

/**
 * Classe criadora de coisas
 * 
 * @author Gabriel
 * 
 */
public class ThingCreator {

	ThingReader reader;
	String id;
	double seed;
	private double redundanceCheck;

	public ThingCreator(String pId, double pSeed) {
		this.id = pId;
		this.seed = pSeed;
		this.reader = new ThingReader(this.id);
	}

	/**
	 * Retorna os atributos de uma determinada coisa
	 * 
	 * @param is
	 *            atributos iniciais.
	 * @return todos os atributos.
	 */
	public ArrayList<Atribute> defineIs() {
		return reader.defineIs();
	}

	/**
	 * Retorna o que uma determinada coisa tem.
	 * 
	 * @param is
	 *            atributos iniciais
	 * @return o que a coisa tem
	 */
	public ArrayList<Thing> defineHas() {

		ArrayList<Thing> things = new ArrayList<Thing>();//Lista onde as coisas serao construidas e guardadas
		ArrayList<String> thingsList = reader.defineHas();//Lista que guarda as tags com as coisas que serao criadas

		for(String thing:thingsList){//Percorre as tags e joga em thing
			
			thing = thing.replace("[", "").replace("]", "");//Abre a tag
			
			String[] thingAndAtributes = thing.split("::");//Espalha os termos da tag em um array
			
			//==============================================================
			
			if(thingAndAtributes.length==1){//se o array tiver 1 termo, cria a coisa.
				this.redundanceCheck++;
				things.add(new Thing(thingAndAtributes[0],(ProceduralGen.getSeed(ProceduralGen.getSeed(this.seed*this.redundanceCheck)))));
			
			//===============================================================
				
			}else if(thingAndAtributes.length==2){//se houver mais de 2 termos, verificar a ocorrencia e criar coisa.
				
				double ch = Double.parseDouble(thingAndAtributes[1]);//Ocorrencia da coisa
				
				this.redundanceCheck++;
				double p = ProceduralGen.getCent(this.seed+this.redundanceCheck);//Um numero pseudorandomico
				
				if((p)<=ch){//Checa se ocorreu
					this.redundanceCheck++;
					things.add(new Thing(thingAndAtributes[0],(ProceduralGen.getSeed(ProceduralGen.getSeed(this.seed*this.redundanceCheck)))));//Cria
				}
			
			//================================================================
				
			}else if(thingAndAtributes.length==3){//Se houver 3 termos, checa e rrepete dentro do alcance determinado.
				
				double ch = Double.parseDouble(thingAndAtributes[1]);//Ocorrencia da coisa
				
				this.redundanceCheck++;
				double p = ProceduralGen.getCent(ProceduralGen.getSeed(this.seed*this.redundanceCheck));//Um numero pseudorandomico
				
				if((p)<=ch){//Checa se ocorreu
					
					int min;//minimo de coisas
					int max;//maximo de coisas
					p = ProceduralGen.getCent(p);//Um numero pseudorandomico
					
					String[] minMaxTemp = thingAndAtributes[2].split("-");//Separa o min do max na tag
					min = Integer.parseInt(minMaxTemp[0]);//Seta o min
					max = Integer.parseInt(minMaxTemp[1]);// Seta o max
					
					int quant = min + (int)((p/100) * ((max - min) + 1));//Calcula a quantidade de coisas a serem criadas.
					
					for(int contador=0;contador<quant;contador++){
						this.redundanceCheck++;
						things.add(new Thing(thingAndAtributes[0],(ProceduralGen.getSeed(ProceduralGen.getSeed(this.seed*this.redundanceCheck)))));//Cria
					}
					
					
					
				}
				
			}
			
			
		}

		return things;
	}

}
