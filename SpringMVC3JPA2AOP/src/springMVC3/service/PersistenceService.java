package springMVC3.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springMVC3.dao.OrderDAOInterface;
import springMVC3.entity.Order;

@Service
public class PersistenceService implements PersistenceServiceInterface {
	@Autowired
	@Qualifier("orderDAO")
	private OrderDAOInterface orderDAOInterface;
	@Transactional
	@Override
	public Long saveOrder(Order mockOrder) {
		return orderDAOInterface.saveOrder(mockOrder);
	}
	@Transactional
	@Override
	public Order getOrderById(Long orderId) {
		return orderDAOInterface.getOrderById(orderId);
	}
	@Transactional
	@Override
	public List<Order> getOrderBySSN(Long SSN) {
		return orderDAOInterface.getOrderBySSN(SSN);
	}
	@Transactional
	@Override
	public List<Order> getAllOrders() {
		return orderDAOInterface.getAllOrders();
	}
	@Transactional
	@Override
	public Boolean deleteOrder(Long orderId) {
		return orderDAOInterface.deleteOrder(orderId);
	}
}

/*
 This is merely a @Service Component Facade layer to group eventual multiple DAO @Repository Components 
 altogether, offering one single @Service Component bean to be injected and used at the controller layer, 
 instead of lots of DAO @Repository Components.
 */

