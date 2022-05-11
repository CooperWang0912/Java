public class Branch {

    private Branch left;

    private Branch right;

    private char info;

    private int num;

    public Branch(Branch left, Branch right){
        this.left = left;
        this.right = right;
    }

    public Branch(char info){
        this.info = info;
    }

    public String toString(){
        return info + "";
    }

    public Branch getLeft() {
        return left;
    }

    public Branch getRight(){
        return right;
    }

    public char getInfo(){
        return info;
    }
}
