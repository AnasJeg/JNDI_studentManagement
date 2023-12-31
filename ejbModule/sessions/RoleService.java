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

@Stateless(name = "roleService")
public class RoleService implements IDao<Role>,IDaoLocal<Role>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@PermitAll
	public Role create(Role o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Role update(Role o) {
		
	    Role st = entityManager.find(Role.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Role not found");
	    
	    st.setName(o.getName());
	   
	    entityManager.merge(st);
	    
	    return st;
	}

	@Override
	@PermitAll
	public boolean delete(Role o) {
	    Role st = entityManager.find(Role.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Role not found");
	    entityManager.remove(st);
	    return true;
	}

	@Override
	@PermitAll
	public Role findById(int id) {
		Role st=entityManager.find(Role.class, id);
		if(st == null) throw new RuntimeException("Role not found");
		return st;
	}

	@Override
	@PermitAll
	public List<Role> findAll() {
		Query query=entityManager.createQuery("select r from Role r");
		// TODO Auto-generated method stub
		return query.getResultList();
	}
	
	@PermitAll
	public void affect(Role r, User u) {

		
	}

	@Override
	public List<Student> findAllByFiliere(Filiere filiere) {
		// TODO Auto-generated method stub
		return null;
	}

}
