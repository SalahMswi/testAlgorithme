package pour_tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class RenduMonnaieTest extends TestCase{

	public void testCalculer() throws Exception {
	RenduMonnaie rm=new RenduMonnaie();
		List<Float> ltest=new LinkedList<Float>();
		Map<Float,Integer> maptest=new LinkedHashMap<Float,Integer>();		//ltest.add(0.0f);
		
		//ltest.add(0.0f);
		maptest.put(2f, 2);
		maptest.put(1f, 1);
		//assertEquals(0.0f,rm.renvoi_monnaie(1.5f));
		
		//assertEquals(ltest,rm.renvoi_monnaie_list(5f));
		assertEquals(maptest,rm.renvoi_monnaie_map(7.5f));

		
	}
}
