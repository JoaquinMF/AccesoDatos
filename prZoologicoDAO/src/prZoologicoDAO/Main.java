package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		
		//Animal a = new Animal("Ardilla","Bosque",0.1);
		//AnimalDAO.insertAnimal(a);
		//AnimalDAO.deleteAnimalByNombre("Ardilla");
		
		
		//Animal b = AnimalDAO.findById(3);
		//System.out.println(b);
		
		//System.out.println(AnimalDAO.findAllAnimales());
		
		Animal a = AnimalDAO.findById(3);
		a.setPeso_aproximado(20);
		
		System.out.println(a);
		
		
	}

}
