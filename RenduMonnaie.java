package pour_tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenduMonnaie {

	private float prix=2f;
	private float[] monnaies={2f,1f,0.5f,0.1f};

	public RenduMonnaie(){
	}
	
	//pour cette méthode je peux utiliser while à la place de if
	//Integer i=m.getValue();
	//i--;
	//m.setValue(i);
public Map<Float, Integer> renvoi_monnaie_map(float argent_depose){
	Map<Float,Integer> mp=new HashMap<Float,Integer>();
	Map<Float,Integer> mp_de_monnaies=new HashMap<Float,Integer>();
	mp.put(2f, 2);
	mp.put(1f, 5);
	mp.put(0.5f, 1);
	
		float reste=argent_depose-prix;
		
		for(Map.Entry<Float , Integer> en:mp.entrySet()){
			if(en.getValue()!=null){
			if(reste>=en.getKey()){
				float rest_division=reste%en.getKey();
				int quotient=(int) (reste/en.getKey());
				
				if(rest_division==0f){
					int a=en.getValue()-quotient;
					if(a>=0)//pr verifier si contient assez de cette monnaie
					{
						mp_de_monnaies.put(en.getKey(), quotient);
					en.setValue(0);
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
