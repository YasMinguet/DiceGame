package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.converter;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Game;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.dto.GameDTO;

public class GameConverter extends AbstractConverter<Game, GameDTO> {

	@Override
	public GameDTO fromEntity(Game entity) {
		return GameDTO.builder().id(entity.getId()).winner(entity.getWinner()).dice1(entity.getDice1())
				.dice2(entity.getDice2()).result(entity.getResult()).build();
	}

	
	@Override
	public Game fromDTO(GameDTO dto) {
		return Game.builder().id(dto.getId()).winner(dto.getWinner()).dice1(dto.getDice1()).dice2(dto.getDice2())
				.result(dto.getResult()).build();

}
}