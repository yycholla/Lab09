import java.util.*;

/**
 * Array-based implementation of IndexedUnsortedList.
 *
 * @author
 *
 * @param <E> type to store
 */
public class IUArrayList<E> implements IndexedUnsortedList<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private static final int NOT_FOUND = -1;

	private E[] array;
	private int rear;
	private int modCount; // DO NOT REMOVE ME

	/** Creates an empty array with default initial capacity */
	public IUArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty array with the given initial capacity
	 * @param initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public IUArrayList(int initialCapacity) {
		array = (E[])(new Object[initialCapacity]);
		rear = 0;
		modCount = 0; // DO NOT REMOVE ME
	}

	/** Double the capacity of array */
	private void expandCapacity() {
		array = Arrays.copyOf(array, array.length*2);
	}

	@Override
	public void addToFront(E element) {
		// TODO Zion
		if (this.size() == this.array.length) { expandCapacity(); }

		modCount++; // DO NOT REMOVE ME

	}

	@Override
	public void addToRear(E element) {
		// TODO Colin
		add();
		modCount++; // DO NOT REMOVE ME
	}

	@Override
	public void add(E element) {
		// TODO Tyler
		if (this.size == this.array.length) {
			expandCapacity();
		}
		int index = front;

		for (int i = 0; i < count && element.compareTo(array[index]) > 0; i++) {
			index++;
		}

		int shift = rear;
		while (shift != index) {
			this.array[shift] = this.array[shift-1];
			shift--;
		}

		array[index] = element;
		rear++;
		count++;
		modCount++; // DO NOT REMOVE ME
	}

	@Override
	public void addAfter(E element, E target) {
		// TODO Kelsi
		modCount++; // DO NOT REMOVE ME
	}

	@Override
	public void add(int index, E element) {
		// TODO Tyra
		modCount++; // DO NOT REMOVE ME
	}

	@Override
	public E removeFirst() {
		// TODO Zion
		this.remove(first());
		modCount++; // DO NOT REMOVE ME
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Colin
		modCount++; // DO NOT REMOVE ME
		return null;
	}

	@Override
	public E remove(E element) {
		int index = indexOf(element);
		if (index == NOT_FOUND) {
			throw new NoSuchElementException();
		}

		E retVal = array[index];

		rear--;
		//shift elements
		for (int i = index; i < rear; i++) {
			array[i] = array[i+1];
		}
		array[rear] = null;

		modCount++; // DO NOT REMOVE ME
		return retVal;
	}

	@Override
	public E remove(int index) {
		// TODO Tyler
		modCount++; // DO NOT REMOVE ME
		return null;
	}

	@Override
	public void set(int index, E element) {
		// TODO Kelsi
		modCount++; // DO NOT REMOVE ME
	}

	@Override
	public E get(int index) {
		// TODO Tyra
		return null;
	}

	@Override
	public int indexOf(E element) {
		int index = NOT_FOUND;

		if (!isEmpty()) {
			int i = 0;
			while (index == NOT_FOUND && i < rear) {
				if (element.equals(array[i])) {
					index = i;
				} else {
					i++;
				}
			}
		}

		return index;
	}

	@Override
	public E first() {
		// TODO Zion
		if (isEmpty()) { throw new NoSuchElementException(); }
		return array[0];
	}

	@Override
	public E last() {
		// TODO Colin
		return null;
	}

	@Override
	public boolean contains(E target) {
		return (indexOf(target) != NOT_FOUND);
	}

	@Override
	public boolean isEmpty() {
		// TODO Tyler
		return false;
	}

	@Override
	public int size() {
		// TODO Kelsi
		return 0;
	}

	@Override
	public String toString() {
		String result = "[";
		// TODO Tyra
		return result + "]";
	}

	// IGNORE THE FOLLOWING COMMENTED OUT CODE UNTIL LAB 10
	// DON'T DELETE ME, HOWEVER!!!
	public Iterator<E> iterator() {
		// return new IUArrayarrayIterator(); // UNCOMMENT ME IN LAB 10
		return null; // REMOVE ME IN LAB 10
	}

	// UNCOMMENT THE CODE BELOW IN LAB 10

	// private class IUArrayarrayIterator implements Iterator<E> {

	// 	private int iterModCount, current;
	// 	private boolean canRemove;

	// 	public IUArrayarrayIterator() {
	// 		iterModCount = modCount;
	// 		current = 0;
	// 		canRemove = false;
	// 	}

	// 	@Override
	// 	public boolean hasNext() {
    //         if (iterModCount != modCount) {
    //             throw new ConcurrentModificationException();
    //         }
    //         return current < rear;
	// 	}

	// 	@Override
	// 	public E next() {
    //         if (!hasNext()) {
    //             throw new NoSuchElementException();
    //         }
    //         E item = array[current];
	// 		current++;
    //         canRemove = true;
    //         return item;
	// 	}

	// 	@Override
	// 	public void remove() {
    //         if (iterModCount != modCount) {
    //             throw new ConcurrentModificationException();
    //         }
    //         if (!canRemove) {
    //             throw new IllegalStateException();
    //         }
    //         // remove the element in the array at index current-1
    //         // presumably decrement the rear
    //         // presumably the modCount is getting incremented
	// 		// all indices have to back up by one
	// 		current--;
	// 		rear--;
	// 		// shift elements to the left
	// 		for (int i = current; i < rear; i++) {
	// 			array[i] = array[i + 1];
	// 		}
	// 		array[rear] = null;
	// 		modCount++;
	// 		iterModCount++;
	// 		// Can only remove the LAST "seen" element
	// 		// set back to a non-removal state
    //         canRemove = false;
	// 	}

	// }

	// IGNORE THE FOLLOWING CODE
	// DON'T DELETE ME, HOWEVER!!!
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int startingIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
