public class Branch {

    private Branch left; //left branch

    private Branch right; //right branch

    private char info; //information

    public Branch(Branch left, Branch right){ //constructor for empty branch
        this.left = left; //set left branch
        this.right = right; //set right branch
    }

    public Branch(char info){
        this.info = info;
    } //constructor for a branch that holds characters

    public String toString(){
        return info + "";
    } //prints info

    public Branch getLeft() {
        return left;
    } //return left branch

    public Branch getRight(){
        return right;
    } //return right branch

    public char getInfo(){
        return info;
    } //return info
}
