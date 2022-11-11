package dao;

import java.util.ArrayList;

public interface InterfazDao<T> {
	
	/**
	 * Muestra todos los objetos T de la base de datos
	 * 
	 * @return ArrayList de T
	 */
	
	public ArrayList<T> buscarTodos();
	
	/**
	 * Muestra el objeto T de la base de datos con el id especificado
	 * @param i el id del objeto T
	 * @return un objeto T
	 */
	
	public T buscarPorId(int i);
	
	/**
	 * Inserta el objeto T recibido en la base de datos
	 * @param t un objeto T
	 */
	
	public void insertar(T t);
	
	/**
	 *Modifica el objeto T especificado en la base de datos
	 * @param t un objeto T
	 */
	
	public void modificar(T t);
	
	/**
	 * Borra el objeto T especificado en la base de datos
	 * @param t Un objeto T
	 */
	
	public void borrar(T t);


}