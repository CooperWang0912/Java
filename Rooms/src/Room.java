import java.util.ArrayList;

public class Room {

    private String name;
    private double l;
    private double w;
    private double h;
    private ArrayList<Material> materials;
    private ArrayList<Double> amountMaterial;

    public Room(String name, double l, double w, double h, ArrayList<Material> materials, ArrayList<Double> amountMaterial){
        this.name = name;
        this.l = l;
        this.w = w;
        this.h = h;
        this.materials = materials;
        this.amountMaterial = amountMaterial;
    }

    public double getPrice() {
    	double t = 0;
    	for(int i = 0; i < materials.size(); i++) {
    		t += materials.get(i).getPrice()*amountMaterial.get(i);
    	}
    	return t;
    }
    public double getArea(){
        return l * w;
    }

    public double getVolume(){
        return  l * w * h;
    }

    public ArrayList<Material> getMaterial(){
        return materials;
    }

    public ArrayList<Double> getAmountMaterial(){
        return amountMaterial;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setL(double l){
        this.l = l;
    }

    public void setW(double w){
        this.w = w;
    }

    public void setH(double h){
        this.h = h;
    }

    public void setMaterial(ArrayList<Material> materials){
        this.materials = materials;
    }

    public void setAmountMaterial(ArrayList<Double> amountMaterial){
        this.amountMaterial = amountMaterial;
    }

    public String toString(){
        String ans = name + " " + l + " " + w + " " + h + " ";
        for (int i = 0; i <= materials.size() - 1; i++){
            ans += materials.get(i).toString() + " ";
        }
        for (int i = 0; i <= amountMaterial.size() - 1; i++){
            ans += amountMaterial.get(i) + " ";
        }
        return ans;
    }

}
