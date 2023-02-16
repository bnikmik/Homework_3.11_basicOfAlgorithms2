import list.MyIngegerList;


public class Main {
    public static void main(String[] args) {
        MyIngegerList list = new MyIngegerList(4);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(4);
        list.contains(5);
        System.out.println(list);
    }
}