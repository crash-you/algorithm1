package com.liumou.Array;


import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {

    private int size = 0;
    private int capacity = 8;
    private int[] array = new int[capacity];

    public void addLest(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    /**
     * 向[0-size-1]添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("输入的信息有误");
            return;
        }
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[size] = element;
        size++;
    }

    /**
     * 删除
     *
     * @return
     */
    public int remove(int index) {
        int removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removed;
    }

    /**
     * 函数时接口遍历
     *
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }

    }

    /**
     * 迭代器遍历
     *
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() { //有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { //返回当前元素，并指针移向下一个元素
                return array[i++];
            }
        };
    }

}
