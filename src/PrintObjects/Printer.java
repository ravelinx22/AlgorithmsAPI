package PrintObjects;
import Models.*;

public class Printer {
	
	public static <Item> void pt(Item item) {
		System.out.print(item);
	}
	
	public static <Item> void ptl(Item item) {
		System.out.println(item);
	}
	
	public static <Item> void ptLinkedList(Node<Item> first) {
		for(Node<Item> cur = first; cur != null; cur = cur.getNext()) {
			pt(cur.getItem() +" ");
		}
		
		ptl("");
	}
	
	public static <Item> void ptArray(Item[] array) {
		for(int i = 0, n = array.length; i < n; i++) {
			pt(array[i] +" ");
		}
		ptl("");
	}
}
