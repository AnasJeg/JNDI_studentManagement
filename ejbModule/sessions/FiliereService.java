package sessions;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import entities.Role;
import entities.Student;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "filiereService")
public class FiliereService implements IDao<Filiere>,IDaoLocal<Filiere>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@PermitAll
	public Filiere create(Filiere o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Filiere update(Filiere o) {
		
	    Filiere st = entityManager.find(Filiere.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Filiere not found");
	    
	    st.setCode(o.getCode());
	    st.setName(o.getName());
	 //   st.setStudents(o.getStudents());
	   
	    entityManager.merge(st);
	    
	    return st;
	}

	@Override
	@PermitAll
	public boolean delete(Filiere o) {
	    Filiere st = entityManager.find(Filiere.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Filiere not found");
	    entityManager.remove(st);
	    return true;
	}

	@Override
	@PermitAll
	public Filiere findById(int id) {
		Filiere st=entityManager.find(Filiere.class, id);
		if(st == null) throw new RuntimeException("Filiere not found");
		return st;
	}

	@Override
	@PermitAll
	public List<Filiere> findAll() {
		Query query=entityManager.createQuery("select f from Filiere f");
		// TODO Auto-generated method stub
		return query.getResultList();
	}

	@Override
	@PermitAll
	public List<Student> findAllByFiliere(Filiere filiere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PermitAll
	public void affect(Role r, User u) {
		// TODO Auto-generated method stub
		
	}

}
