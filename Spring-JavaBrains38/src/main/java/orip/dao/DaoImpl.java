package orip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orip.dto.Circle;

@Component
public class DaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
	public Circle getCircle(int id) {
		
		Circle circle = null;
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, id);
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
