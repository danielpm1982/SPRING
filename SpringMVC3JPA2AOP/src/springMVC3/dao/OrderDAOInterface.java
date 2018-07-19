package springMVC3.dao;
import java.util.List;

import springMVC3.entity.Order;

public interface OrderDAOInterface {
	public Long saveOrder(Order mockOrder);
	public Order getOrderById(Long orderId);
	public List<Order> getOrderBySSN(Long SSN);
	public List<Order> getAllOrders();
	public Boolean deleteOrder(Long orderId);
}
