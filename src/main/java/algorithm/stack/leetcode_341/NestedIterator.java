package algorithm.stack.leetcode_341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        NestedInteger curr = stack.peek();
        while (!curr.isInteger()) {
            stack.pop();
            List<NestedInteger> currList = curr.getList();
            for(int i = currList.size() - 1; i >=0; i--) {
                stack.push(currList.get(i));
            }
            if(stack.isEmpty()) return false;
            curr = stack.peek();
        }
        return true;
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedIntegerList1 = new ArrayList<>();
        nestedIntegerList1.add(new NestedIntegerImpl(1));

        NestedInteger nestedInteger1 = new NestedIntegerImpl(nestedIntegerList1);
        NestedInteger nestedInteger2 = new NestedIntegerImpl(4);

        List<NestedInteger> nestedIntegerList2 = new ArrayList<>();
        nestedIntegerList2.add(nestedInteger2);
        nestedIntegerList2.add(nestedInteger1);

        NestedInteger nestedInteger3 = new NestedIntegerImpl(nestedIntegerList2);

        NestedInteger nestedInteger4 = new NestedIntegerImpl(1);
        List<NestedInteger> nestedIntegerList = new ArrayList<>();
        nestedIntegerList.add(nestedInteger4);
        nestedIntegerList.add(nestedInteger3);

        NestedIterator iterator = new NestedIterator(nestedIntegerList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class NestedIntegerImpl implements NestedInteger {

    private Integer value;

    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer value) {
        this.value = value;
    }
    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}