package Top100;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    int p = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        methodIterator(nestedList);
    }

    private void methodIterator(List<NestedInteger> nestedList) {
        for (NestedInteger ne : nestedList) {
            if (ne.isInteger()) {
                list.add(ne.getInteger());
            } else
                methodIterator(ne.getList());
        }
    }

    @Override
    public Integer next() {
        return list.get(p++);
    }

    @Override
    public boolean hasNext() {

        return p < list.size();
    }
}