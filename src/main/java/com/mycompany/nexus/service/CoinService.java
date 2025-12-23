package com.mycompany.nexus.service;
import com.mycompany.nexus.Model.Coin;
import com.mycompany.nexus.dto.CoinDTO;
import com.mycompany.nexus.repository.CoinRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String coinGeckoUrl;

    @Autowired
    private CoinRepo repo;

    // 1️⃣ Sync CoinGecko → DB
    public void seekForCoins() {

        String url = coinGeckoUrl +
            "/coins/markets?vs_currency=usd&order=market_cap_desc";

        CoinDTO[] coins = restTemplate.getForObject(url, CoinDTO[].class);

        for (CoinDTO c : coins) {
            Coin coin = new Coin();
            coin.setSymbol(c.getSymbol());
            coin.setName(c.getName());
            coin.setImage(c.getImage());
            coin.setPrice(c.getCurrent_price());
            coin.setPrice_change_percentage_24h(
                c.getPrice_change_percentage_24h()
            );

            repo.save(coin);
        }
    }

    // 2️⃣ DB → FRONTEND SHAPE
    public List<CoinDTO> getAllCoins() {

        return repo.findAll().stream().map(c -> {
            CoinDTO dto = new CoinDTO();
            dto.setSymbol(c.getSymbol());
            dto.setName(c.getName());
            dto.setImage(c.getImage());
            dto.setCurrent_price(c.getPrice());
            dto.setPrice_change_percentage_24h(
                c.getPrice_change_percentage_24h()
            );
            return dto;
        }).toList();
    }
}
