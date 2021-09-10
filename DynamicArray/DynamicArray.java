package createdynamicarray;

public class DynamicArray {
	//creating reference for array
	private int data[];
	//index to traverse array and check values
	private int nextElementIndex;
	
	
	//constructor to initialize array's values
	public DynamicArray() {
		data = new int[5];
		nextElementIndex = 0;
	}
	
	public int size() {
		return nextElementIndex;
	}
	
	public boolean isEmpty() {
		return nextElementIndex == 0;
	}
	
	public int get(int i) {
		if(i >= nextElementIndex) {
			//throw error or return -1
			return -1;
		}
		return data[i];
	}
	
	public void set(int i, int elem) {
		if(i >= nextElementIndex) {
			//throw error or return
			return;
		}
		data[i] = elem;
	}
	
	public void add(int elem) {
		//if array size has been reached, double the size of the array
		if(nextElementIndex == data.length) {
			doubleCapacity();
		}
		data[nextElementIndex] = elem;
		nextElementIndex++;
	}
	
	public void doubleCapacity() {
		//storing reference of old array in temp
		int temp[] = data;
		//creating new array of length twice that of older array
		data = new int[2 * temp.length];
		//copying data from older array to new array
		for(int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}	
	}
	
	public int removeLast() {
		//if array is empty, return -1
		if(nextElementIndex == 0) {
			return -1;
		}
		int temp = data[nextElementIndex -1];
		//setting deleted element as 0
		data[nextElementIndex - 1] = 0;
		nextElementIndex--;
		return temp;
	}

}
