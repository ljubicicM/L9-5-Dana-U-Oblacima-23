package com.example.L9Project.Player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class PlayerController {
	
	public static void main(String[] args) {
		SpringApplication.run(PlayerController.class, args);
		}
	
	private final PlayerService playerService;
	
	public PlayerController() {
		this.playerService = new PlayerService();
	}
	
	@GetMapping("/players/stats/{id}")
	@ResponseBody
	public String getPlayerById(@PathVariable String id) {
		return playerService.returnPlayer(id).toString();
	}
}
