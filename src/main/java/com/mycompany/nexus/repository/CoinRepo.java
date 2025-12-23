package com.mycompany.nexus.repository;

import com.mycompany.nexus.Model.Coin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CoinRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getStatus() {
        return jdbcTemplate.queryForObject("SELECT 'DB connected'", String.class);
    }

    public List<Coin> findAll() {
        return jdbcTemplate.query("SELECT * FROM coins", coinRowMapper());
    }

    public void save(Coin c) {
        String sql = """
            INSERT INTO coins(symbol, name, price, image,price_change_percentage_24h)
            VALUES (?, ?, ?, ?,?)
            ON DUPLICATE KEY UPDATE
            name = VALUES(name),
            price = VALUES(price),
            image = VALUES(image),
            price_change_percentage_24h = VALUES(price_change_percentage_24h)
        """;

        jdbcTemplate.update(sql,
                c.getSymbol(),
                c.getName(),
                c.getPrice(),
                c.getImage(),
                c.getPrice_change_percentage_24h()
        );
    }

    private RowMapper<Coin> coinRowMapper() {
        return (rs, rowNum) -> {
            Coin c = new Coin();
            c.setId(rs.getInt("id"));
            c.setSymbol(rs.getString("symbol"));
            c.setName(rs.getString("name"));
            c.setPrice(rs.getDouble("price"));
            c.setImage(rs.getString("image"));
            c.setPrice_change_percentage_24h(rs.getDouble("price_change_percentage_24h"));
            return c;
        };
    }
}
