import list.MyIngegerList;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        MyIngegerList list = new MyIngegerList(4);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        System.out.println(list.contains(1));

        int count = 100_000;
        MyIngegerList myStringList = new MyIngegerList(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            myStringList.add(random.nextInt(99999)+1);
        }

        long start = System.currentTimeMillis();
        myStringList.sortInsertion();
        System.out.println(System.currentTimeMillis() - start);

//        System.out.println(myStringList);


        //пузырек - 33 сек
        //выбор - 7 сек
        //вставка - 5 сек

    }
}