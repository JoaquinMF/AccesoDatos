package main;

import dao.PeliculaDao;
import dao.SalaDao;

public class Main {
	
	SalaDao salaDao = new SalaDao();
	PeliculaDao peliculaDao = new PeliculaDao();
	
	//INSERCION
    System.out.println("\n\nINSERCION DE DATOS:");
	Sala c = new Sala("NombreMal", 951926104);
	salaDao.insertar(c);
	Sala d = salaDao.buscarPorId(1);
	Libro l1 = new Libro(1, "El apagaon", "FILOSOFIA", d);
	Libro l2 = new Libro(2, "Tormenta de espadas", "NARRATIVA", d);
	Libro l3 = new Libro(3, "La inercia del silencio", "POESIA", d);
	libroDao.insertar(l1);
	libroDao.insertar(l2);
	libroDao.insertar(l3);
	Biblioteca p = new Biblioteca("Provincial", 951920530);
	bibliotecaDao.insertar(p);
	Biblioteca s = bibliotecaDao.buscarPorId(2);
	Libro b1 = new Libro(4, "Hamlet", "TEATRO", s);
	Libro b2 = new Libro(5, "Churchill: La biografia", "BIOGRAFIAS", s);
	Libro b3 = new Libro(6, "Prisioneros de la geografia", "GEOGRAFIA", s);
	libroDao.insertar(b1);
	libroDao.insertar(b2);
	libroDao.insertar(b3);
	System.out.println("Datos insertados");
	
	//CONSULTA
    System.out.println("\n\nCONSULTA DE DATOS: ");
    System.out.println("Bibliotecas de la base de datos con sus libros correspondientes: ");
    ArrayList<Biblioteca> bibliotecas = bibliotecaDao.buscarTodos();
    for (Biblioteca biblioteca : bibliotecas) {
        System.out.println("Biblioteca: "+biblioteca.getNombre());
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println("Libro: "+libro.getTitulo());
        }
    }
    
	//MODIFICACION
    System.out.println("\n\nMODIFICACION DE DATOS:");
    l2.setTitulo("The Witcher");
    libroDao.modificar(l2);
    Libro l1modificado = libroDao.buscarPorId(l2.getId());
    System.out.println("Titulo modificado: " + l1modificado.getTitulo());
    
    c.setNombre("Cervantes");
    bibliotecaDao.modificar(c);
    System.out.println("Nombre modificado: " + c.getNombre());

	//ELIMINACION
    System.out.println("\n\nELIMINACION DE DATOS:");
    libroDao.borrar(l3);
    Libro l3borrado = libroDao.buscarPorId(l3.getId());
    if (l3borrado == null) {
        System.out.println("Libro borrado.");
    } else {
        System.err.println("Libro no borrado.");
    }
    
    bibliotecaDao.borrar(s);
    Biblioteca pborrado = bibliotecaDao.buscarPorId(s.getId());
    if (pborrado == null) {
        System.out.println("Biblioteca borrada.");
    } else {
        System.err.println("Biblioteca no borrada.");
    }
	
	

}
