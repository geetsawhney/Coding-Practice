package stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	private ArrayList<Stack<Integer>> listOfStacks;
	private int threshold;
	private int size;
	private int currentIndex;


	public SetOfStacks() {
		listOfStacks=new ArrayList<>();
		threshold=10;
		size=0;
		currentIndex=-1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return listOfStacks.isEmpty();
	}
	
	public void push(int value) {
		
		if(isEmpty() || listOfStacks.get(currentIndex).size()==threshold){
			System.out.println("Adding index at index"+(currentIndex+1));
			listOfStacks.add(new Stack<>());
			currentIndex++;
		}
		listOfStacks.get(currentIndex).push(value);
		size++;
	}
	
	public int pop() {
		if(isEmpty()){
			System.out.println("Empty stack");
			return -1;
		}
		int output=listOfStacks.get(currentIndex).pop();
		size--;	
		if(listOfStacks.get(currentIndex).isEmpty()){
			listOfStacks.remove(currentIndex);
			currentIndex--;
		}
		return output;
	}
	
	public int popAt(int index) {
		if(index>currentIndex || listOfStacks.get(index).size()==0){
			return -1;
		}
		int output=listOfStacks.get(index).pop();
		size--;
		
		if(listOfStacks.get(index).isEmpty()){
			listOfStacks.remove(index);
			currentIndex--;
		}
		return output;		
	}
}
