package sn.gestionscolarite.app;

import java.util.List;

import sn.gestionexception.app.BadFormatException;


public interface Dao<T> {

	public void add (T obj) throws BadFormatException;
	public void update (T obj) throws BadFormatException;
	public void delete (int id) throws BadFormatException;
	public List<T> list () throws BadFormatException;
	public T read (int id) throws BadFormatException;


}
