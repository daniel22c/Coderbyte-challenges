
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;
class Data{
	String path;
	int count;
	public Data(String path, int count) {
		this.count = 0;
		this.path = path;
	}
}
public class ShortestPath {  
  public static String path(String[] str) { 
  	int N = Integer.parseInt(str[0]);
  	ArrayList<String> nodes = new ArrayList();
  	ArrayList<String> edges = new ArrayList();
  	for(int i=0;i<N;i++)
  	{
  		nodes.add(str[i+1]);
  	}
  	
  	for(int i=N+1;i<str.length;i++)
  	{
  		edges.add(str[i]);
  	}
  	Map<String, List<String>> dic = new HashMap<>();
  	for(String edge : edges) {
  		String start = edge.substring(0,1);
  		String end = edge.substring(2,3);
  		if(dic.containsKey(start)) {
  			dic.get(start).add(end);
  		}else {
  			List<String> arr = new ArrayList<String>();
  			arr.add(end);
  			dic.put(start,  arr);
  		}
  	}
  	System.out.println(dic);
  	Queue<String> q = new LinkedList<>();
  	TreeMap<String, Integer> visited = new TreeMap<>();
  	String first = str[1];
  	String last = str[N];
  	q.add(first);
  	while(!q.isEmpty()) {
  		String node = q.poll();
  		if(node.equals(last)) {
  			continue;
  		}
  		List<String> neighbors = dic.get(node);
  		if(neighbors!=null && !neighbors.isEmpty()) {
  			for(String neighbor : neighbors) {
  				q.add(neighbor);
  				if(neighbor.equals(last)) {
  					List<String> list = new ArrayList<>();
  	  				list.add(node);
  	  	  			list.addAll(q);
  	  	  			String key = list.toString();
  	  	  			System.out.println("key"+key);
  	  	  			if(!visited.containsKey(key)) {
  	  	  				visited.put(key, list.size());
  	  	  			}	
  				}
  				
  	  		}	
  		}
  		
  	}
  	System.out.println(visited);
  	System.out.println(visited.firstKey());
	return visited.firstKey();
    
  } 
  
  
  public static void main (String[] args) {  
	  String[] path1 = new String[] {"4","A","B","C","D","A-B","B-D","B-C","C-D"};
	  String[] path2 = new String[] {"7","A","B","C","D","E","F","G","A-B","A-E","B-C","C-D","D-F","E-D","F-G"};
	  String ret = ShortestPath.path(path1);
	  System.out.println("shortest path:"+ret);
	  String ret2 = ShortestPath.path(path2);
	  System.out.println("shortest path:"+ret2);
	  /*
	   * 
	  4,A,B,C,D,A-B,B-D,B-C,C-D
	  7,A,B,C,D,E,F,G,A-B,A-E,B-C,C-D,D-F,E-D,F-G
	  5,A,B,C,D,F,A-B,A-C,B-C,C-D,D-F
	  4,X,Y,Z,W,X-Y,Y-Z,X-W
	  6,Z,B,C,A,Y,Q,B-C,A-B,A-Z,C-Y,Z-Y,C-Q
	   * */
  }

}
