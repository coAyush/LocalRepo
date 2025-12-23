package com.mycompany.nexus.controllers;
import com.mycompany.nexus.dto.CoinDTO;
import com.mycompany.nexus.service.CoinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class CoinController {

    @Autowired
    private CoinService service;

    // frontend endpoint
    @GetMapping("/coins")
    public List<CoinDTO> getAllCoins() {
        return service.getAllCoins();
    }

    // manual sync
    @GetMapping("/coins/sync")
    public String syncCoins() {
        service.seekForCoins();
        return "Coins synced successfully";
    }
}
