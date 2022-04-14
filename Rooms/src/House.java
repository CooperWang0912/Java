import java.util.ArrayList;

public class House {
	static ArrayList<Room> rooms = new ArrayList<Room>();
	public House() {
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	public double getPrice() {
		double t = 0;
		for(int i = 0; i < rooms.size(); i++) {
			t += rooms.get(i).getPrice();
		}
		return t;
	}
	
	public double getVolume() {
		double t = 0;
		for(int i = 0; i < rooms.size(); i++) {
			t += rooms.get(i).getVolume();
		}
		return t;
	}
	
	public double getSquareFt() {
		double t = 0;
		for(int i = 0; i < rooms.size(); i++) {
			t += rooms.get(i).getArea();
		}
		return t;
	}
	
	public void setName(int i, String name){
        rooms.get(i).setName(name);
    }

    public void setL(int i, double l){
    	rooms.get(i).setL(l);
    }

    public void setW(int i, double w){
    	rooms.get(i).setW(w);
    }

    public void setH(int i, double h){
    	rooms.get(i).setH(h);
    }

    public void setMaterial(int i, ArrayList<Material> materials){
    	rooms.get(i).setMaterial(materials);
    }

    public void setAmountMaterial(int i, ArrayList<Double> amountMaterial){
    	rooms.get(i).setAmountMaterial(amountMaterial);
    }

	public String toString() {
		return rooms.toString();
	}

	public String recommendation(int i){
		return "Recommended for " + Math.ceil(rooms.get(i).getArea() / 200) + " people";
	}

	public static void main(String[]args){
		House a = new House();
		ArrayList<Material> b = new ArrayList<Material>();
		ArrayList<Material> d = new ArrayList<Material>();
		b.add(new Material("metal", 50));
		d.add(new Material("Bronze", 70));
		ArrayList<Double> c = new ArrayList<Double>();
		ArrayList<Double> e = new ArrayList<Double>();
		c.add(50.0);
		e.add(70.0);
		rooms.add(new Room("guest", 10, 10, 10, b, c));
		System.out.println(a.getPrice());
		System.out.println(a.getSquareFt());
		System.out.println(a.getVolume());
		a.addRoom(new Room("kitchen", 10, 10, 10, b, c));
		a.setName(1, "bedroom");
		a.setL(1, 20);
		a.setW(1, 20);
		a.setH(1, 20);
		a.setMaterial(1, d);
		a.setAmountMaterial(1, e);
		System.out.println(a.getPrice());
		System.out.println(a.getSquareFt());
		System.out.println(a.getVolume());
		System.out.println(a);
		System.out.println(a.recommendation(0));
		System.out.println(a.recommendation(1));
	}
}
