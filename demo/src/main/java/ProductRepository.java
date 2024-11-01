import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("wattage"),
                rs.getDouble("price"),
                rs.getDouble("efficiency"),
                rs.getString("image")
        ));
    }

    public List<Product> searchProductsByWattage(int wattage) {
        String sql = "SELECT * FROM products WHERE wattage = ?";
        return jdbcTemplate.query(sql, new Object[]{wattage}, (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("wattage"),
                rs.getDouble("price"),
                rs.getDouble("efficiency"),
                rs.getString("image")
        ));
    }
}
