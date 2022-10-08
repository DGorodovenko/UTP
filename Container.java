import java.util.ArrayList;
import java.util.List;


public final class Container<TElement extends IAggregable<TElement, TResult> & IDeeplyCloneable<TElement>, TResult> implements IContainer<TElement,TResult>{

    private List<TElement> elements;

    public Container(){}

    public Container(ArrayList<TElement> t) {
        this.elements = t;

    }
    @Override
    public List<TElement> elements() {
        return elements;
    }

    @Override
    public TResult aggregateAllElements() {
        TResult result = null;
        for (TElement element : elements) result = element.aggregate(result);
        return result;
    }

    @Override
    public TElement cloneElementAtIndex(int index) {
        if (index < 0) return null;
        if (elements.size() <= index) return null;

        TElement element = elements.get(index);
        return element.deepClone();
    }

    public void  add(TElement t){
        elements.add(t);
    }

}
