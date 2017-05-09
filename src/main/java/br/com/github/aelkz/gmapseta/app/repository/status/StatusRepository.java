package br.com.github.aelkz.gmapseta.app.repository.status;

import br.com.github.aelkz.gmapseta.app.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatusRepository extends MongoRepository<Status, String>, StatusRepositoryCustom {
}
