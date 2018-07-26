package springMVC3.model;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DAO {
	private static SessionFactory factory;
	public static void initialize(HttpServletRequest request) {
		try {
			factory = (SessionFactory)request.getServletContext().getAttribute("factory");
			if(factory==null||factory.isClosed()) {
				factory = new Configuration().addAnnotatedClass(Order.class).configure("hibernate.cfg.xml").buildSessionFactory();
//				truncateAllTables(factory);
				request.getServletContext().setAttribute("factory",factory);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
		}
	}
	public static boolean terminate(HttpServletRequest request) {
		try {
			if(factory!=null&&factory.isOpen()) {
				factory.close();
				request.setAttribute("factory", null);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return false;
		} finally {
		}
	}
	public static boolean isInitialized() {
		return (factory!=null&&factory.isOpen());
	}
	public static Long saveOrder(Order mockOrder) {
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.getTransaction().begin();
			Long orderId = (Long)session.save(mockOrder);
			session.getTransaction().commit();
			return orderId;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}
	public static Order getOrderById(Long orderId) {
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.getTransaction().begin();
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
			session.getTransaction().commit();
			return order;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}
	public static List<Order> getOrderBySSN(Long SSN) {
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.getTransaction().begin();
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
			session.getTransaction().commit();
			return orderList;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}
	public static List<Order> getAllOrders() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.getTransaction().begin();
//			List<Order> ordersList = session.createQuery("from Order",Order.class).getResultList();
//			List<Order> ordersList = session.createNamedQuery("Order.getAllOrders", Order.class).getResultList();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Order> cq = cb.createQuery(Order.class);
			Root<Order> root = cq.from(Order.class);
			cq.select(root);
			Query<Order> query = session.createQuery(cq);
			List<Order> orderList = query.getResultList();
			session.getTransaction().commit();
			return orderList;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}
	public static boolean deleteOrder(Long orderId) {
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.getTransaction().begin();
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
			session.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println("Order not found for id="+orderId+"! Not deleted!");
			return false;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return false;
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
	}
//	private static boolean truncateAllTables() {
//		boolean b1 = truncateTable("scheme1.order");
//		return b1;
//	}
//	private static boolean truncateTable(String fullQualifiedTableName) {
//		Session session = null;
//		try {
//			session = factory.getCurrentSession();
//			session.getTransaction().begin();
//			System.out.println("Truncating table "+fullQualifiedTableName+":");
//			session.createNativeQuery("truncate "+fullQualifiedTableName).executeUpdate();
//			System.out.println("Successfully truncated!");
//			session.getTransaction().commit();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//			return false;
//		} finally {
//			if(session!=null&&session.isOpen()) {
//				session.close();
//			}
//		}
//	}
}
