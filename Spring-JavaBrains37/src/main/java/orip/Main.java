package orip;

import orip.dao.DAOImpl;
import orip.dto.Circle;

public class Main {
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());
	}
}
