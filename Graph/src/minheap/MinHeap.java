package minheap;

import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<T, V>{

  private ArrayList<Element<T, V>> queue;
  private Comparator<T> tComparator;
  private Comparator<V> vComparator;
  private int size;

  /**
   * Constructor for the Element class.
   */
  public MinHeap(Comparator<T> tComparator, Comparator<V> vComparator){
    this.queue = new ArrayList<Element<T, V>>();
    this.tComparator = tComparator;
    this.vComparator = vComparator;
    size = queue.size();
  }

  /**
   * @return  true if the queue is empty.
   */
  public boolean isEmpty(){
    return queue.isEmpty();
  }

  /**
   * [size description]
   * @return [description]
   */
  public int size(){
    return size;
  }

  /**
   * gives the index of the parent of the element in position i in the queue
   * @param  i the index of the element
   * @return   the index of the parent
   */
  private int parent(int i){
    return (i-1)/2;
  }

  /**
   * gives the index of the left node of the element in position i in the queue
   * @param  i the index of the element
   * @return   the index of the left node or i if left node doesn't exist
   */
  private int left(int i){
    if(((i*2)+1) < size)
      return ((i*2)+1);

    return i;
  }

  /**
   * gives the index of the right node of the element in position i in the queue
   * @param  i the index of the element
   * @return   the index of the right node i if right node doesn't exist
   */
  private int right(int i){
    if(((i+1)*2) < size)
      return ((i+1)*2);

    return i;
  }

  public Element<T,V> getElementAt(int i){
    if(i < size)
      return queue.get(i);

    return null;
  }

  /**
	 * Insert a new element into the queue.
	 * @param el   the element to insert
	 */
  public void insert(Element<T, V> el){
    queue.add(new Element<T, V>(null, null));
    size++;
    int i = size-1;

    while(i > 0 && vComparator.compare(queue.get(parent(i)).getKey(), el.getKey()) > 0){
      queue.set(i, queue.get(parent(i)));
      i = parent(i);
    }
    queue.set(i, el);
  }

  /**
   * Returns the element with the lowest key in the queue.
   * @return   the value of the element with the lowest Key.
   */
  public Element<T, V> minimum() throws MinHeapException{
    if(queue.isEmpty())
      throw new MinHeapException("heap is empty");

    return queue.get(0);
  }

  /**
   * Removes and returns the element with the lowest key in the queue.
   * @return   the value of the element with the lowest Key.
   */
	public Element<T, V> extractMin() throws MinHeapException{
    if(queue.isEmpty())
      throw new MinHeapException("heap is empty");

    Element<T, V> min = queue.get(0);
    queue.set(0, queue.get(size-1));
    queue.remove(size-1);
    size--;

    heapify(0);

    return min;
	}

  /**
   * turns the queue in min-heap
   * @param i the first index
   */
  public void heapify(int i){
    int left = left(i);
    int right = right(i);
    int smallest = i;

    if(size > left && vComparator.compare(queue.get(left).getKey(), queue.get(i).getKey()) < 0)
      smallest = left;

    if(size > right && vComparator.compare(queue.get(right).getKey(), queue.get(smallest).getKey()) < 0)
      smallest = right;

    if(smallest != i){
      swap(i, smallest);
      heapify(smallest);
    }
  }

  /**
   * swaps two elements in queue in position i and j
   * @param i the index of the first element to swap
   * @param j the index of the second element to swap
   */
  private void swap(int i, int j){
    Element<T, V> tmp = queue.get(i);
    queue.set(i, queue.get(j));
    queue.set(j, tmp);
  }

  /**
   * upgrades the key of element el with newKey
   * @param i      index of the current element
   * @param el     the element whit the key to upgrade
   * @param newKey the value of the new key of el
   */
  public void decreaseKey(int i, V newKey) throws MinHeapException{
    if(vComparator.compare(newKey, getElementAt(i).getKey()) > 0)
       throw new MinHeapException("New key is bigger than current key");

    getElementAt(i).setKey(newKey);
    int parent = parent(i);

    while (i > 0 && vComparator.compare(getElementAt(parent).getKey(), getElementAt(i).getKey()) > 0) {
      swap(i, parent);
      i = parent;
      parent = parent(i);
    }
  }

  /**
   * [increaseKey description]
   * @param i      [description]
   * @param newKey [description]
   */
  public void increaseKey(int i, V newKey) throws MinHeapException{
    if(vComparator.compare(newKey, getElementAt(i).getKey()) < 0)
      throw new MinHeapException("New key is smaller than current key");

    getElementAt(i).setKey(newKey);

    heapify(i);
  }

  /**
   * [containsElement description]
   * @param  heap     [description]
   * @param  value [description]
   * @return       [description]
   */
  public int containsElement(T value){
    for(int i = 0; getElementAt(i) != null; i++)
      if(tComparator.compare(value, getElementAt(i).getValue()) == 0)
        return i;

    return -1;
  }

}
