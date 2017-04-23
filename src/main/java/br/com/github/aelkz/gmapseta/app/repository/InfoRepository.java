package br.com.github.aelkz.gmapseta.app.repository;

import br.com.github.aelkz.gmapseta.app.model.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoRepository extends MongoRepository<Info, String>, InfoRepositoryCustom {
}
