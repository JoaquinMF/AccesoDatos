package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		
		//Animal a = new Animal("Ardilla","Bosque",0.1);
		//AnimalDAO.insertAnimal(a);
		//AnimalDAO.deleteAnimalByNombre("Ardilla");
		
		
		Animal b = AnimalDAO.findById(3);
		System.out.println(b);
		
		
	}

}
