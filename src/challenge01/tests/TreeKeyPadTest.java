package challenge01.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import challenge01.Edge;
import challenge01.EdgeType;
import challenge01.TreeKeyPad;


public class TreeKeyPadTest {

	
	@Test
	public void testConstructor() throws IOException{
		TreeKeyPad myTree = new TreeKeyPad();
		System.out.println(myTree);
		List<Edge> myList = myTree.getNodes().get(2);
		Edge edge0 = new Edge(1, EdgeType.HORIZONTAL);
		Edge edge1 = new Edge(4, EdgeType.DIAGONAL);
		Edge edge2 = new Edge(5, EdgeType.VERTICAL);		
		List<Edge> myListEdges = Arrays.asList(new Edge []{edge0, edge1, edge2});
		assertEquals(myList, myListEdges);
	}
	
	@Test
	public void testRutaMinima() throws IOException{
		TreeKeyPad myTree = new TreeKeyPad();
		//Edge edge0 = new Edge(0, null);
		//Edge edge1 = new Edge(1, EdgeType.HORIZONTAL);
		//Edge edge2 = new Edge(7, EdgeType.VERTICAL);		
		//List<Edge> myListEdges = Arrays.asList(new Edge []{edge0, edge1});
		
		assertEquals(200, myTree.calculaRuta(0, 1).intValue());
		
		assertEquals(400, myTree.calculaRuta(0, 2).intValue());
		
		assertEquals(350, myTree.calculaRuta(0, 4).intValue());

		assertEquals(0, myTree.calculaRuta(0, 0).intValue());

		assertEquals(350, myTree.calculaRuta(4, 0).intValue());

		assertEquals(700, myTree.calculaRuta(0, 8).intValue());

		assertEquals(300, myTree.calculaRuta(10, 7).intValue());

		assertEquals(900, myTree.calculaRuta(10, 1).intValue());

		assertEquals(900, myTree.calculaRuta(1, 10).intValue());
		
		assertEquals(950, myTree.calculaRuta(10, 0).intValue());
		
	}
	
}
