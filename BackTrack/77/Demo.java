import java.util.*;

class Demo{
    List<Integer> insider = new ArrayList<>();
    LinkedList<Integer> newinsider = new LinkedList<>();

    public static void main(String[] args) {
        Demo demo = new Demo();
        List<List<Integer>> res = new ArrayList<>();
        demo.insider.add(0);
        demo.insider.add(1);
        demo.newinsider.add(0);
        demo.newinsider.add(2);
        res.add(demo.insider);
        res.add(demo.newinsider);
        System.out.println("res now is: " + res);
        demo.insider.remove(demo.insider.size() - 1);
        demo.insider.add(9);
        demo.newinsider.removeLast();
        demo.newinsider.add(8);
        System.out.println("res now is: " + res);
        return;
    }
}