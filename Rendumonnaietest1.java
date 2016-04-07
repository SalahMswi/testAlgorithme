package algotest1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class) //avant la classe tjrs

public class Rendumonnaietest1  {

	//private final Float argent;
	private Map<Float,Integer> caisse;

	/*
	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(
	            new Object[] { 8.5f},
	            new Object[] { 5f }

	        );
	}
	 */
	@Parameters
	public static Collection<Object[]> params() {
		Map<Float,Integer> caisse1=new LinkedHashMap<Float,Integer>();
		Map<Float,Integer> caisse2=new LinkedHashMap<Float,Integer>();
		//caisse1
		caisse1.put(2f, 2);
		caisse1.put(1f, 4);
		caisse1.put(0.5f, 2);
		caisse1.put(0.2f, 5);
		caisse1.put(0.1f, 10);

		//caisse2
		caisse2.put(2f, 4);
		caisse2.put(1f, 5);
		caisse2.put(0.5f, 6);
		caisse2.put(0.2f, 5);
		caisse2.put(0.1f, 10);

		return Arrays.asList(
				new Object[] { caisse1},
				new Object[] { caisse2}


				);
	}

	public Rendumonnaietest1(final Map caisse) {
		this.caisse = caisse;
		// this.nb = nb;
	}


	@Test
	public void renvoi_monnaie_map_Test() {

		
		Map<Float,Integer> maptest=new LinkedHashMap<Float,Integer>();	
		maptest.put(2f, 2);
		maptest.put(1f, 1);

		//RenduMonnaie rm=new RenduMonnaie();
		//rm.remplir_caisse(monnaie,nb);
		assertEquals(maptest,RenduMonnaie.renvoi_monnaie_map(10.50f,caisse));

	}




}
