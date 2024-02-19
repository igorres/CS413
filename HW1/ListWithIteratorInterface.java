package HW1;
import java.util.Iterator;

public interface ListWithIteratorInterface<E> extends Iterable<E>{

    public Iterator<E> getIterator();
    
}