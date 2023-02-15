package list;

import exceptions.ElementNotFoundException;
import exceptions.ListNotFoundException;
import exceptions.NonexistentIndexException;

import java.util.Arrays;

public class MyIngegerList implements IntegerList {
    private Integer[] integers;
    private int size;


    public MyIngegerList(int size) {
        if (size > 0) {
            this.integers = new Integer[size];
        } else if (size == 0) {
            this.integers = new Integer[10];
        } else {
            throw new IllegalArgumentException("Illegal size: " +
                    size);
        }
    }

    /**
     * Adding a new item to the array. If the array is full, then it increases
     *
     * @param item - new item for array
     * @return the element that was added to the array
     */
    @Override
    public Integer add(Integer item) {
        getIncreaseArray();
        integers[size++] = item;
        return item;
    }

    /**
     * Adding an item to a specific position in the list. If the array is full, then it increases
     *
     * @param index - element index
     * @param item  - new item for array
     * @return the element that was added to the array
     */
    @Override
    public Integer add(int index, Integer item) {
        checkIndex(index);
        getIncreaseArray();
        Integer[] temp = Arrays.copyOf(integers, size);
        System.arraycopy(temp, 0, integers, 0, index);
        integers[index] = item;
        System.arraycopy(temp, index, integers, index + 1, temp.length - index);
        size++;
        return item;
    }

    /**
     * get new array if last element != null
     */
    private void getIncreaseArray() {
        if (integers[integers.length - 1] != null) {
            integers = Arrays.copyOf(integers, integers.length * 2);
        }
    }

    /**
     * Setting an item to a specific position in the list.
     *
     * @param index - element index
     * @param item  - new item for array
     * @return the element that is set in the array
     */
    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        integers[index] = item;
        return item;
    }

    /**
     * Checking index. If it goes beyond the actual array, throw an exception.
     *
     * @param index - element index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new NonexistentIndexException("Индекс " + index + " не существует в листе");
        }
    }

    /**
     * Deleting an element from the array.
     *
     * @param item - element of array
     * @return the element that is removed from the array
     */
    @Override
    public Integer remove(Integer item) {
        if (!contains(item)) {
            throw new ElementNotFoundException("Элемент " + item + " не найден");
        }
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] != null && integers[i].equals(item)) {
                System.arraycopy(integers, i + 1, integers, i, integers.length - i - 1);
                size--;
            }
        }
        return item;
    }

    /**
     * Deleting an element from an array by index
     *
     * @param index - element index
     * @return the element that is removed from the array
     */
    @Override
    public Integer remove(int index) {
        checkIndex(index);
        if (integers[index] == null) {
            throw new ElementNotFoundException("Элемент по индексу " + index + " не найден");
        }
        Integer result = integers[index];
        System.arraycopy(integers, index + 1, integers, index, integers.length - index - 1);
        size--;
        return result;
    }

    /**
     * Checking for the existence of an element in the array.
     *
     * @param item - element of array
     * @return true/false
     */
    @Override
    public boolean contains(Integer item) {
        for (Integer integer : integers) {
            if (integer != null && integer.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searching for an element in an array from the beginning
     *
     * @param item - element of array
     * @return - index of element. if element not found return -1
     */
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] != null && integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searching for an element in an array from the end
     *
     * @param item - element of array
     * @return - index of element. if element not found return -1
     */
    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integers.length - 1; i >= 0; i--) {
            if (integers[i] != null && integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get an item by index.
     *
     * @param index - element index
     * @return element of array
     */
    @Override
    public Integer get(int index) {
        checkIndex(index);
        if (integers[index] == null) {
            throw new ElementNotFoundException("Элемент не существует");
        }
        return integers[index];
    }

    /**
     * Compare the current list with another
     *
     * @param otherList - other list
     * @return comparison result
     */
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new ListNotFoundException();
        }
        if (this.size() != otherList.size()) return false;
        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return the actual number of items.
     *
     * @return size of list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checking for the presence of items in the list.
     *
     * @return true/false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Remove all elements from the list.
     */
    @Override
    public void clear() {
        int length = integers.length;
        integers = new Integer[length];
        size = 0;
    }

    /**
     * Create a new array of list items.
     *
     * @return array
     */
    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(integers, size));
    }
}
