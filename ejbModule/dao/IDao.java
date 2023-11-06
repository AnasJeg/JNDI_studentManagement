package dao;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IDao<T> {
	T create(T o);

	T update(T o);

	boolean delete(T o);

	T findById(Long id);

	List<T> findAll();
}
