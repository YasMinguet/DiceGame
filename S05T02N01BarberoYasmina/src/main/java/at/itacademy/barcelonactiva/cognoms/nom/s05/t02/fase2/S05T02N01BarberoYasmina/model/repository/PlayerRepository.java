package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;

public interface PlayerRepository extends MongoRepository<Player, Long> {

	public Player findByName(String name);

}