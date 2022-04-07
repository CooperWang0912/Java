public class Test {
    public static void main(String[]args){
        LinkedList<String> a = new LinkedList<String>();
        a.add("ha");
        a.add("1");
        a.add("2");
        a.add("3");
        System.out.println(a.getSize());
        System.out.println(a.get(2));
        a.remove(2);
        System.out.println(a.get(2));
        a.addIndex("2", 2);
        a.addIndex("hahaha", 0);
        a.addIndex("hohoho", 5);
        System.out.println(a.get(2));
        System.out.println(a);
    }
}
