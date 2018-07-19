package springMVC3.dao;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springMVC3.entity.Order;
import springMVC3.entity.Order_;

@Repository
public class OrderDAO implements OrderDAOInterface{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Long saveOrder(Order mockOrder) {
		Session session = sessionFactory.getCurrentSession();
		Long orderId = (Long)session.save(mockOrder);
		return orderId;
	}
	@Override
	public Order getOrderById(Long orderId) {
		Session session = sessionFactory.getCurrentSession();
//			Order order = session.get(Order.class, orderId);
//			Order order = session.createNamedQuery("Order.getOrderById", Order.class).setParameter("id", orderId).getSingleResult();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Order> cq = cb.createQuery(Order.class);
			Root<Order> root = cq.from(Order.class);
			cq.select(root);
//			Predicate predicate = cb.equal(root.<Long>get("id"), orderId);
			Predicate predicate = cb.equal(root.get(Order_.id), orderId);
			cq.where(predicate);
			Query<Order> query = session.createQuery(cq);
			Order order = query.getSingleResult();
			return order;
	}
	@Override
	public List<Order> getOrderBySSN(Long SSN) {
		Session session = sessionFactory.getCurrentSession();
//			List<Order> orderList = session.createQuery("select o from Order o where o.SSN = "+SSN+" order by o.id asc",Order.class).getResultList();
//			List<Order> orderList = session.createNamedQuery("Order.getOrderBySSN",Order.class).setParameter("SSN", SSN).getResultList();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		cq.select(root);
//			Predicate predicate = cb.equal(root.<Long>get("SSN"), orderId);
		Predicate predicate = cb.equal(root.get(Order_.SSN), SSN);
		cq.where(predicate);
		Query<Order> query = session.createQuery(cq);
		List<Order> orderList = query.getResultList();
		return orderList;
	}
	@Override
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
//			List<Order> ordersList = session.createQuery("from Order",Order.class).getResultList();
//			List<Order> ordersList = session.createNamedQuery("Order.getAllOrders", Order.class).getResultList();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> root = cq.from(Order.class);
		cq.select(root);
		Query<Order> query = session.createQuery(cq);
		List<Order> orderList = query.getResultList();
		return orderList;
	}
	@Override
	public Boolean deleteOrder(Long orderId) {
		Session session = sessionFactory.getCurrentSession();
//			Order order= session.get(Order.class, orderId);
//			session.delete(order);
//			session.createNamedQuery("Order.deleteOrder").setParameter("id", orderId).executeUpdate();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Order> cd = cb.createCriteriaDelete(Order.class);
		Root<Order> root = cd.from(Order.class);
		Predicate predicate = cb.equal(root.get(Order_.id), orderId);
		cd.where(predicate);
		javax.persistence.Query query = session.createQuery(cd);
		query.executeUpdate();
		return true;
	}
}
