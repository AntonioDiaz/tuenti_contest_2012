package challenge01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tree simulating the movements of the finger on the keypad of a call phone.
 * @author toni
 *
 */
public class TreeKeyPad {

	/**
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public TreeKeyPad() throws IOException{
		String fileName = "keyTree.txt";
		InputStream inputStream = getClass().getResourceAsStream(fileName);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		String linea;
		nodes = new ArrayList<List<Edge>>();
		while ((linea = bufferReader.readLine())!=null){
			/* to avoid process comments. */
			if (!linea.startsWith("//") && !"".equals(linea)){
				//7:3_D,4_V,5_D,6_H,8_H,9_D,10_H,11_D
				String[] strings = linea.split(":");
				String[] edgesStr = strings[1].split(",");
				List<Edge> edges = new ArrayList<Edge>();
				for (String edgeStr : edgesStr) {
					String[] edge = edgeStr.split("_");
					edges.add(new Edge(Integer.valueOf(edge[0]), EdgeType.convertEdgeType(edge[1].charAt(0))));
				}
				nodes.add(edges);
			}
		}
	}
	
	private int encuentraRuta = 0;

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	public Integer calculaRuta (Integer origin, Integer destination){
		List<Edge> listaRecorridos = new ArrayList<Edge>();
		listaRecorridos.add(new Edge(origin, null));
		if (!origin.equals(destination)){
			this.encuentraRuta = Integer.MAX_VALUE;
			this.calculaDistanciaMinimaAnchura(origin, destination, listaRecorridos, 0);
		} else {
			this.encuentraRuta = 0;
		}
		return this.encuentraRuta;
	}

	/**
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public int calculaDistanciaMinimaAnchura(Integer origen, Integer destino, List<Edge> listaRecorridos, int sumaParcial) {
		if (origen.equals(destino)) {
			return sumaParcial;
		} else {
			/* Busco todos los destinos de origen. */
			int encontrado = -1;
			for (int i = 0; i < this.getNodes().get(origen).size(); i++) {
				Edge nodo = this.getNodes().get(origen).get(i);
				if (!TreeKeyPad.buscaCiclos (listaRecorridos, nodo)) {
					listaRecorridos.add(nodo);
					int nuevaSuma = sumaParcial + nodo.getType().getEdgeCost();
					if (nuevaSuma < encuentraRuta) {
						encontrado = calculaDistanciaMinimaAnchura(nodo.getTarget(), destino, listaRecorridos, nuevaSuma);
						if (encontrado!=-1 && encontrado<encuentraRuta) {
							encuentraRuta = encontrado;
						}
					}
					listaRecorridos.remove(nodo);
				}
			}
			return encontrado;
		}
	}
	
	/**
	 * 
	 * @param listaRecorridos
	 * @param nodo
	 * @return
	 */
	private static boolean buscaCiclos(List<Edge> listaRecorridos, Edge nodo){
		boolean encontrado = false;
		for (Edge myNodo : listaRecorridos) {
			if (myNodo.getTarget().equals(nodo.getTarget())) {
				encontrado = true;
			}
		}
		return encontrado;
	}	
	
	List<List<Edge>> nodes;

	public List<List<Edge>> getNodes() {
		return nodes;
	}

	@Override
	public String toString() {
		return "TreeKeyPad [nodes=" + nodes + "]";
	}

	
	
	
}
