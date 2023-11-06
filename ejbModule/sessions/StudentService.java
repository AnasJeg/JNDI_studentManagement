package sessions;

import java.util.List;

import dao.IDao;
import entities.Student;
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
	    
	    st.setLogin(o.getLogin());
	    st.setPassword(o.getPassword());
	    st.setFiliere(o.getFiliere());
	    st.setFirstname(o.getFirstname());
	    st.setLastname(o.getLastname());
	    st.setTell(o.getTell());
	    st.setRoles(o.getRoles());
	    
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
	public Student findById(Long id) {
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

}
