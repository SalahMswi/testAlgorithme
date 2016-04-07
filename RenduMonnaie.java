package algotest1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RenduMonnaie {

	private static float prix=2f;
	private float[] monnaies={2f,1f,0.5f,0.1f};
	private static Map<Float,Integer> caisse=new HashMap<Float,Integer>();

	public RenduMonnaie(){
	}
	
	//cette méthode rempli la caisse par le test junit parmétrisé
	//j'ai céer cette méthode pour essayer de remplir la caisse par test parmétrisé
	//mais elle marche pas car à chaque fois je crer un nouveau objet alors nouvelle caisse
public static void remplir_caisse(Float monnaie,Integer nombre_monnaie){
		
	boolean exist=false;
	for(Map.Entry<Float, Integer> en:caisse.entrySet()){
		if(caisse.containsKey(monnaie))
		{
			en.setValue(nombre_monnaie);
			exist=true;
		}
		
	}
	if(exist==false)
		caisse.put(monnaie, nombre_monnaie);
	}

	//pour cette méthode je peux utiliser while à la place de if
	//Integer i=m.getValue();
	//i--;
	//m.setValue(i);
public static Map<Float, Integer> renvoi_monnaie_map(float argent_depose,Map<Float,Integer> mp){
	//Map<Float,Integer> mp=new HashMap<Float,Integer>();
	Map<Float,Integer> mp_de_monnaies=new LinkedHashMap<Float,Integer>();
/*
	mp.put(2f, 2);
	mp.put(1f, 4);
	mp.put(0.5f, 2);
	mp.put(0.1f, 10);
*/
		float reste=argent_depose-prix;
		float rest_division=0.0f;
		for(Map.Entry<Float , Integer> en:mp.entrySet()){
			if(en.getValue()!=null){
			if(reste>=en.getKey()){
				rest_division=reste%en.getKey();
				
			
				int quotient=(int) (reste/en.getKey());
				
				if(rest_division==0f){
					int a=en.getValue()-quotient;
					if(a>=0)//pr verifier si contient assez de cette monnaie
					{
						mp_de_monnaies.put(en.getKey(), quotient);
					en.setValue(a);//il y a un problème là
					
					
					break;
					}
					else{
						mp_de_monnaies.put(en.getKey(), en.getValue());
						reste=rest_division-en.getKey()*a;
					en.setValue(0);
					}
				}else{
					int a=en.getValue()-quotient;
					if(a>=0)//pr verifier si contient assez de cette monnaie
					{
						mp_de_monnaies.put(en.getKey(), quotient);
					en.setValue(0);//je vide la caisse de cette monnaie
					reste=rest_division;
					}
					else{
						mp_de_monnaies.put(en.getKey(), en.getValue());
						reste=rest_division-en.getKey()*a;//j'ajoute le quotient * la monnaie au reste quand on n'a pas assez 
						en.setValue(0);//je vide la caisse de cette monnaie

					}
				}
				
			}
			}
		}
		
		return  mp_de_monnaies;

	}
	
//test 2
	public List<Float> renvoi_monnaie_list(float argent_depose){
		
		float reste=argent_depose-prix;
		List<Float> lm=new ArrayList<Float>();
		lm.add(0.0f);
		for(int i=0;i<monnaies.length;i++){
			if(reste>=monnaies[i]){
				reste=reste%monnaies[i];
				lm.add(monnaies[i]);
			}
		}
		return lm;

	}
	//test1
	public float renvoi_monnaie(float argent_depose){
		float reste=argent_depose-prix;

		if(argent_depose>prix){
		for(int i=0;i<monnaies.length;i++){
			if(reste>monnaies[i]){
				reste=reste%monnaies[i];
			}
		}
		
		}
		return reste;

	}

	public static void main(String[] args) {

	}

}
