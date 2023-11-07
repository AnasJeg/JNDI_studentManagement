package sessions;

import java.util.List;

import dao.IDao;
import entities.Filiere;
import entities.Role;
import entities.Student;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "studentService")
public class StudentService implements IDao<Student>{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student create(Student o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	public Student update(Student o) {
		
	    Student st = entityManager.find(Student.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Student not found");
	    
        st.setLogin(st.getLogin());
        st.setPassword(st.getPassword());
        st.setFiliere(st.getFiliere());
        st.setFirstname(st.getFirstname());
        st.setLastname(st.getLastname());
        st.setTell(st.getTell());
        st.setRoles(st.getRoles());
	    
	    entityManager.merge(st);
	    
	    return st;
	}

	@Override
	public boolean delete(Student o) {
	    Student st = entityManager.find(Student.class, o.getId());
	    
	    if (st == null) throw new RuntimeException("Student not found");
	    entityManager.remove(st);
	    return true;
	}

	@Override
	public Student findById(int id) {
		Student st=entityManager.find(Student.class, id);
		if(st == null) throw new RuntimeException("student not found");
		return st;
	}

	@Override
	public List<Student> findAll() {
		Query query=entityManager.createQuery("select s from Student s");
		// TODO Auto-generated method stub
		return query.getResultList();
	}
	
	public List<Student> findAllByFiliere(Filiere filiere) {
		Query query=entityManager.createQuery("select s from Student s where s.filiere =: filiere");
		query.setParameter("filiere", filiere);
		// TODO Auto-generated method stub
		return query.getResultList();
	}

	@Override
	public void affect(Role r, User u) {
		// TODO Auto-generated method stub
		
	}

}
