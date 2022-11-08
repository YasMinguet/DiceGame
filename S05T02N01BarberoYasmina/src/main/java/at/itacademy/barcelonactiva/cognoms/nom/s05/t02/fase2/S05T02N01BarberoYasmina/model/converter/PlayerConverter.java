package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.converter;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.dto.PlayerDTO;

public class PlayerConverter extends AbstractConverter<Player,PlayerDTO>{

	@Override
	public PlayerDTO fromEntity(Player entity) {
		return PlayerDTO.builder().
				id(entity.getId()).
				name(entity.getName()).	
				dateReg(entity.getDateReg()).
				winGames(entity.getWinGames()).
				lostGames(entity.getLostGames()).
				average(entity.getAverage()).
				totalGames(entity.getTotalGames()).build();
	}

	

	@Override
	public Player fromDTO(PlayerDTO dto) {
		return Player.builder().
				id(dto.getId()).
				name(dto.getName()).	
				dateReg(dto.getDateReg()).
				winGames(dto.getWinGames()).
				lostGames(dto.getLostGames()).
				average(dto.getAverage()).
				totalGames(dto.getTotalGames()).build();
	}

}
