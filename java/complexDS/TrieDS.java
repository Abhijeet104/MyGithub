package complexDS;
import java.util.HashMap;
import java.util.Scanner;


public class TrieDS {
	static Node root = new Node((Character)null);
	
	public static void main(String args[]){
		
		String list[] = {"abcd","a","aaa","adcb"};
		Node node = null, cur = root;
		int i ;
		for(String s: list){
			i = 0;
			cur = root;										//careful, each time set cur to root and start
			while(i<s.length()){
				node = new Node(s.charAt(i));
				if(!cur.child.containsKey(s.charAt(i)))		//Careful here, without this if you would replace earlier node with new node for latest string
					cur.child.put(s.charAt(i),node);
				cur = cur.child.get(s.charAt(i));
				i++;
			}
			cur.setEnd(true);
		}
		
		System.out.print("Type a string which you want to search in trie:\n ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(find(s))
			System.out.print("Typed string exist in list");
		else
			System.out.print("Typed string doesn't exist in list");
	}
	
	
	
	public static boolean find(String s){
		Node cur = root;
		int i = 0;
		while(i<s.length()){
			if(cur.child.containsKey(s.charAt(i))){
				cur.child.get(s.charAt(i));
				cur = cur.child.get(s.charAt(i));
				i++;
			}
			else return false;
		}
		return cur.isEnd();
	}
	
}


class Node{
	Character ch;
	boolean isEnd;

	HashMap<Character,Node> child = new HashMap<Character,Node>();
	public Node(Character c){
		ch = c;
		isEnd = false;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
}