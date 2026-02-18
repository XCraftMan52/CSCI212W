@SuppressWarnings("unchecked")
public class MyArrayList<E> implements MyList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[])new Object[INITIAL_CAPACITY];
    private int size = 0;

    public MyArrayList()
    {

    }

    public MyArrayList(E[] objects)
    {
        for (int i = 0; 1 < objects.length; i++)
        {
            add(objects[i]);
        }
    }
    public void add(int index, E e)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException
            ("Index:" + index + ", Size: " + size);
        }
        ensureCapacity();

        for (int i = size - 1; i >= index; i--)
        {
            data[i + 1] = data[i];
        }
        data[index] = e;

        size++;
    }

    public void ensureCapacity()
    {
        if (size >= data.length) {
            E[] newData = (E[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public void clear()
    {
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean contains(Object e)
    {
        for(int i = 0; i < size; i++)
            if (e.equals(data[i])) return true;
        return false;
    }

    public E get(int index)
    {
        checkIndex(index);
        return data[index];
    }

    public void checkIndex(int index)
    {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException
            ("Index:" + index + ", Size: " + size);
        }
    }

    public int indexOf(Object e)
    {
        for(int i=0; i < size; i++)
            if (e.equals(data[i])) return i;
        return -1;
    }

    public int lastIndexOf(E e)
    {
        for(int i = size - 1; i >= 0;i--)
        {
            if (e.equals(data[i]))
            {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index)
    {
        checkIndex(index);

        E e = data[index];

        // Shift data to the left
        for (int j = index; j < size - 1;j++)
            data[j] = data[j+1];

        data[size - 1] = null;

        size--;

        return e;
    }

    public E set(int index, E e)
    {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if(i < size - 1) result.append(", ");
        }

        return result.toString();
    }

    public void trimToSize()
    {
        if (size != data.length)
        {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, size,0);
            data = newData;
        }
    }

    public java.util.Iterator<E> iterator()
    {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E>
    {
        private int current = 0;

        public boolean hasNext()
        {
            return current < size;
        }

        public E next()
        {
            return data[current++];
        }

        public void remove()
        {
            if(current == 0)
                throw new IllegalStateException();
            MyArrayList.this.remove(--current);
        }
    }
    public int size()
    {
        return size;
    } 
}
