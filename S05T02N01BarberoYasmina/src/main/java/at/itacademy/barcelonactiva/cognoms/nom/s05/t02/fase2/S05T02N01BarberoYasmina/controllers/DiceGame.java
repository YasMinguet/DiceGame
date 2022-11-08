package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.converter.GameConverter;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.converter.PlayerConverter;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Game;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.dto.GameDTO;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.dto.PlayerDTO;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services.DiceGameService;

@RestController
public class DiceGame {
		@Autowired
		private  DiceGameService service;
		
		private PlayerConverter playerConverter=new PlayerConverter();
		
		private GameConverter gameConverter=new GameConverter();

		// Lista un jugador del sistema
		
		@GetMapping("/players/{id}")
		public ResponseEntity<PlayerDTO> getPlayer(@PathVariable(value = "id") Long idPlayer) {
			Player player = service.getPlayer(idPlayer);
			PlayerDTO playerDTO = playerConverter.fromEntity(player);
			return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.OK);

		}

		// Crear jugador

		
		@PostMapping("/players")
		public ResponseEntity<PlayerDTO> createPayer(@RequestBody Player player) {
			Player newPlayer = service.createPlayer(player);
			PlayerDTO playerDTO =playerConverter.fromEntity(newPlayer);
			return new ResponseEntity<PlayerDTO>(playerDTO, HttpStatus.CREATED);
		}

		// Modifica el nombre del jugador
		
		@PutMapping("/players")
		public ResponseEntity<PlayerDTO> modifyPlayerName(@RequestBody PlayerDTO player) {
			Player updatedPlayer = service.updatePlayerName(playerConverter.fromDTO(player));
			PlayerDTO updatedPlayerDTO = playerConverter.fromEntity(updatedPlayer);
			return new ResponseEntity<PlayerDTO>(updatedPlayerDTO, HttpStatus.CREATED);

		}

		// Un jugador realiza una tirada de dados
		
		@PostMapping("/players/{id}/games")
		public ResponseEntity<GameDTO> newGame(@PathVariable(value = "id") Long idPlayer) {
			try {
				Player player = service.getPlayer(idPlayer);
				Game newGame = player.plays();			
				GameDTO newGameDTO=gameConverter.fromEntity(service.createGame(idPlayer, newGame));
				return new ResponseEntity<>(newGameDTO, HttpStatus.OK);		
				
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		// Elimina las jugadas del jugador
		
		@DeleteMapping("/players/{id}/games")
		public ResponseEntity<List<GameDTO>> deleteGamesByPlayer(@PathVariable Long id) {
			List<GameDTO>gamesdto=gameConverter.fromEntity(service.deleteGamesByPlayer(id));
			return new ResponseEntity<List<GameDTO>>(gamesdto, HttpStatus.OK);
		}
		// Retorna el listado de todos los jugadores

		@GetMapping("/players")
		public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
			List<Player> players = service.getPlayers();
			List<PlayerDTO> playersdto = playerConverter.fromEntity(players);
			return new ResponseEntity<List<PlayerDTO>>(playersdto, HttpStatus.OK);
		}
		// Listado de jugadas de un jugador

		@GetMapping("/players/{id}/games")
		public ResponseEntity<List<GameDTO>> getGamesByPlayer(@PathVariable Long id) {
			List<Game>getGames=service.deleteGamesByPlayer(id);
			List<GameDTO>gamesDTO=gameConverter.fromEntity(getGames);
			return new ResponseEntity<List<GameDTO>>(gamesDTO, HttpStatus.OK);
		}

		// Retorna el ranking medio de todos los jugadores del sistema

		@GetMapping("/players/ranking")
		public ResponseEntity<Double> getRankingPlayers() {
			
			return new ResponseEntity<Double>(service.averageRanking(), HttpStatus.OK);
		}
		//Retorna el jugador o los jugadores con mejor ranking del sistema en caso de empate 

		@GetMapping("/players/ranking/winner")
		public ResponseEntity<List<PlayerDTO>> getTheBestPlayer() {
			List<Player> players = service.theBestPlayer();
			List<PlayerDTO> theBestPlayerDTO = playerConverter.fromEntity(players);
			return new ResponseEntity<List<PlayerDTO>>(theBestPlayerDTO, HttpStatus.OK);
		}
		// Retorna el jugador o los jugadores con peor ranking del sistema en caso de empate 

		@GetMapping("/players/ranking/loser")
		public ResponseEntity<List<PlayerDTO>> getTheWorstPlayer() {
			List<Player> players = service.theWorstPlayer();
			List<PlayerDTO> theWorstPlayerDTO = playerConverter.fromEntity(players);
			return new ResponseEntity<List<PlayerDTO>>(theWorstPlayerDTO, HttpStatus.OK);
		}

		

	

}
