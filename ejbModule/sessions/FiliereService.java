package sessions;

import java.util.List;

import dao.IDao;
import entities.Filiere;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "filiereService")
public class FiliereService implements IDao<Filiere>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Filiere create(Filiere o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	public Filiere update(Filiere o) {
		
	    Filiere st = entityManager.find(Filiere.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Filiere not found");
	    
	    st.setCode(o.getCode());
	    st.setName(o.getName());
	    st.setStudents(o.getStudents());
	   
	    entityManager.merge(st);
	    
	    return st;
	}

	@Override
	public boolean delete(Filiere o) {
	    Filiere st = entityManager.find(Filiere.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Filiere not found");
	    entityManager.remove(st);
	    return true;
	}

	@Override
	public Filiere findById(Long id) {
		Filiere st=entityManager.find(Filiere.class, id);
		if(st == null) throw new RuntimeException("Filiere not found");
		return st;
	}

	@Override
	public List<Filiere> findAll() {
		Query query=entityManager.createQuery("select f from Filiere f");
		// TODO Auto-generated method stub
		return query.getResultList();
	}

}
