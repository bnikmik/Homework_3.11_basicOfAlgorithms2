import list.MyIngegerList;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        MyIngegerList myStringList = new MyIngegerList(10);
        myStringList.add(123);
        myStringList.add(2);
        myStringList.add(333);
        System.out.println(myStringList.size());
        myStringList.add(3, 2);
        System.out.println(myStringList);
//        myStringList.add(6, "aaa");
//        myStringList.add(2, "111111");
//        myStringList.add(2, "a22");
//        myStringList.clear();

        System.out.println(myStringList);


        System.out.println(Arrays.toString(myStringList.toArray()));



    }
}