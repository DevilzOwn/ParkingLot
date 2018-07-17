package Iterator;

import Parking.Slot;
import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    Stack<Iterator<Slot>> stack = new Stack<Iterator<Slot>>();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        } else{
            Iterator<Slot> iterator = stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }
            else{
                return true;
            }
        }
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        if(hasNext()){
            Iterator<Slot> iterator = stack.peek();
            Slot slot = iterator.next();
            stack.push(slot.createIterator());
            return slot;
        }
        else{
            return null;
        }
    }
}
