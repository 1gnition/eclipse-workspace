package orip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import orip.dto.Circle;

public class DAOImpl {
	public Circle getCircle(int id) {
		
		Circle circle = null;
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/javabrains-spring37",
					"postgres", "password");
			PreparedStatement ps = connection
					.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle();
				circle.setId(rs.getInt("id"));
				circle.setName(rs.getString("name"));
			}
			
			rs.close();
			ps.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
