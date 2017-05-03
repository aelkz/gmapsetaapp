package br.com.github.aelkz.gmapseta.app.repository;

import br.com.github.aelkz.gmapseta.app.model.Info;

public interface InfoRepositoryCustom {
    Info findTraffic(String id);

    Info findTraffic(String id,String position);

    Info findBestRoute(Integer origin);
}
