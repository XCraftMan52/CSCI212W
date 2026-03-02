import java.util.Collection;

public interface MyList<E> extends Collection<E>
{
    // Add a new element at the specified Index
    public void add(int index, E e);

    // Return the element from the list at a specified index
    public E get(int index);

    // Return the index of the first matching element in the list
    public int indexOf(Object e);

    // Returns the index of the last matching element of the list
    public int lastIndexOf(E e);

    // Remove a element at a specified position
    public E remove(int index);

    // Replace the element with a specified element and return the list.
    public E set(int index, E e);

    // Add new element at the end of the list
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    public default boolean isEmpty() {
        return size() == 0;
    }
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }

    public default boolean containsAll(Collection<?> c) {
        return true;
    }

    public default boolean addAll(Collection<? extends E> c) {
        return true;
    }

    public default boolean removeAll(Collection<?> c) {
        return true;
    }

    public default boolean retainAll(Collection<?> c) {
        return true;
    }

    public default Object[] toArray() {
        return null;
    }

    
    public default <T> T[] toArray(T[] a) {
        return null;
    }

}