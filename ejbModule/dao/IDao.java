package dao;

import java.util.List;

import entities.Filiere;
import entities.Role;
import entities.Student;
import entities.User;
import jakarta.ejb.Remote;

@Remote
public interface IDao<T> {
	T create(T o);

	T update(T o);

	boolean delete(T o);

	T findById(int id);

	List<T> findAll();
	public List<Student> findAllByFiliere(Filiere filiere);
	public void affect(Role r, User u);
}
