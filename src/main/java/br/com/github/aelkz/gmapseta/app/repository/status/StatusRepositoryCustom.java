package br.com.github.aelkz.gmapseta.app.repository.status;

import br.com.github.aelkz.gmapseta.app.model.Status;

import java.util.List;

public interface StatusRepositoryCustom {
    Status findStatus(String id);

    List<Status> findAll(Integer origin);
}
