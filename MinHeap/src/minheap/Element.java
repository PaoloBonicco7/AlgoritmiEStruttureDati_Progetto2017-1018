package minheap;

public class Element<T,V>{

  private T value;
  private V key;

  /**
   * Constructor for the Element class.
   * @param val the element's value.
   * @param key the element's priority.
   */
  public Element(T val, V key) {
    this.value = val;
    this.key = key;
  }


  public T getValue(){
    return value;
  }

  public V getKey(){
    return key;
  }

  /**
   * Set a new key for a Element
   * @param newKey The new key to insert
   */
  public void setKey(V newKey){
    key = newKey;
  }
}
