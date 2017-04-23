package br.com.github.aelkz.gmapseta.app.repository;

import br.com.github.aelkz.gmapseta.app.model.Info;

public interface InfoRepositoryCustom {
    Info findTraffic(String id);
}
