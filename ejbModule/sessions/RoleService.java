package sessions;

import java.util.List;

import dao.IDao;
import entities.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "roleService")
public class RoleService implements IDao<Role>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Role create(Role o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	public Role update(Role o) {
		
	    Role st = entityManager.find(Role.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Role not found");
	    
	    st.setName(o.getName());
	   
	    entityManager.merge(st);
	    
	    return st;
	}

	@Override
	public boolean delete(Role o) {
	    Role st = entityManager.find(Role.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Role not found");
	    entityManager.remove(st);
	    return true;
	}

	@Override
	public Role findById(Long id) {
		Role st=entityManager.find(Role.class, id);
		if(st == null) throw new RuntimeException("Role not found");
		return st;
	}

	@Override
	public List<Role> findAll() {
		Query query=entityManager.createQuery("select f from Role f");
		// TODO Auto-generated method stub
		return query.getResultList();
	}

}
