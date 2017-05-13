package basic.mylist;

import java.util.Arrays;

import javafx.scene.chart.PieChart.Data;

public class MyArrayList<E> implements ListInterface<E> {
	private Object[] elementData;
	private static Object[] EMPTY_ELEMNETDATA = {};
	private int size;
	private static final int DEFAULTE_SIZE = 10;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;

	public MyArrayList() {
		this(0);
	}

	public MyArrayList(int initSize) {
		if (initSize > 0) {
			this.elementData = new Object[initSize];
		} else if (initSize == 0) {
			this.elementData = EMPTY_ELEMNETDATA;
		} else {
			throw new IllegalArgumentException("init size can not be small than zero");
		}
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object obje) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		rangeCheckForGet(index);
		return elementData(index);
	}
	
    @SuppressWarnings("unchecked")
	E elementData(int index){
		return (E)elementData[index];
	}
    
    private void rangeCheckForGet(int index){
    	if(index<0 || index>=size){
    		throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    	}
    }

	@Override
	public void set(int index, E e) {
		rangeCheckForGet(index);
		elementData[index]=e;
	}

	@Override
	public int indexOf(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(E e) {
		ensureCapacityInter(size + 1);
		elementData[size++]=e;
	}

	private void ensureCapacityInter(int capacity) {
		if (elementData == EMPTY_ELEMNETDATA) {
			capacity = Math.max(DEFAULTE_SIZE, capacity);
		}
		ensureExplictCapacity(capacity);
	}

	private void ensureExplictCapacity(int capacity) {
		if (capacity > elementData.length) {
			grow(capacity);
		}
	}

	private void grow(int capacity) {
		int oldCapacity = elementData.length;
		// 右移一位相当于除以二，容量扩充为原来的1.5倍数
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		//取两者中的最大值
		if (newCapacity < capacity) {
			newCapacity = capacity;
		}
		
		if(newCapacity-MAX_ARRAY_SIZE>0){
			newCapacity = hugeCapacity(capacity);
		}
		elementData = Arrays.copyOf(elementData, newCapacity);
		
	}

	private int hugeCapacity(int capacity) {
		if (capacity < 0) {// int 溢出了,就会为负
			throw new OutOfMemoryError();
		}
		return capacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	@Override
	public void add(int index, E element) {
		rangeCheck(index);
		ensureCapacityInter(size+1);
		//将index以后（包括index)的元素向后移动一位，采用复制的方式
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=element;
		size++;
	}

	private void rangeCheck(int index) {
		//只允许在[0,size]中选择，替换
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private String outOfBoundsMsg(int index){
		return "Index:"+index+",Size="+size;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
