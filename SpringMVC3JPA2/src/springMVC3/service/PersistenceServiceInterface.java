package springMVC3.service;
import java.util.List;
import springMVC3.entity.Order;

public interface PersistenceServiceInterface {
	public Long saveOrder(Order mockOrder);
	public Order getOrderById(Long orderId);
	public List<Order> getOrderBySSN(Long SSN);
	public List<Order> getAllOrders();
	public boolean deleteOrder(Long orderId);
}
