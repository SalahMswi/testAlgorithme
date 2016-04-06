package pour_tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class RenduMonnaieTest extends TestCase{

	public void testCalculer() throws Exception {
		RenduMonnaie rm=new RenduMonnaie();
		List<Float> ltest=new LinkedList<Float>();
		//ltest.add(0.0f);
		ltest.add(0.0f);

		//assertEquals(0.0f,rm.renvoi_monnaie(1.5f));
		
		//assertEquals(ltest,rm.renvoi_monnaie_list(5f));
		assertEquals(ltest,rm.renvoi_monnaie_map(8.5f));

		
	}
}