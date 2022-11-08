package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.security.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
}
