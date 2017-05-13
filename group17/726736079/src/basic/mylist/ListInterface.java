package basic.mylist;

public interface ListInterface<E> {

	 int size();
	 boolean isEmpty();
	 boolean contains(Object obje);
	 void clear();
	 E get(int index);
	 void set(int index ,E e);
	 int indexOf(Object obj);
	 
	
	public void add(E obj);
	public void add(int index,E obj);
	public E remove(int index);
	
}
