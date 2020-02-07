package tuc.ece.cs102.shop;


import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.list.SortedList;

public class EnchancedSortedList extends SortedList{
	public EnchancedSortedList() {
		super();
	}
	
	public Item searchAnItem(String key){
		Node tmp = head;
		while (tmp!= null){
			if (tmp.getValue().key().equals(key)){
				return tmp.getValue();
			}
			tmp = tmp.getNext();
		}
		return null;
	}
	
	public void printAllInHierarchy(String className){
		Node temp = head;
		try{
			while (temp!=null){
				Item item = temp.getValue();				
				if (Class.forName(className).isInstance(item.getData())){
					item.print();
				}
				temp = temp.getNext();
			}
		}catch (ClassNotFoundException exception){
			System.out.println("The class named "+className+" does not exist...");
		}		
	}
	

}
