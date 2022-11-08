package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Game;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services.DiceGameService;



@Configuration
public class LoadingData {
	@Bean
	public CommandLineRunner loadData(DiceGameService service) {
		return (args) -> {
			if (service.countAllPlayers() == 0) {
				Player player1 = new Player("Agustin");
				Player player2 = new Player("Salva");
				Player player3 = new Player("Adela");
				Player player4 = new Player("Jose");
				Player player5 = new Player("Manolo");

				service.createPlayer(player1);
				service.createPlayer(player2);
				service.createPlayer(player3);
				service.createPlayer(player4);
				service.createPlayer(player5);

				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());
				service.createGame(player1.getId(), new Game());

				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());
				service.createGame(player2.getId(), new Game());

				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());
				service.createGame(player3.getId(), new Game());

				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());
				service.createGame(player4.getId(), new Game());

				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());
				service.createGame(player5.getId(), new Game());

			}
		};
	}
}
