package br.com.github.aelkz.gmapseta.app.repository.info;

import br.com.github.aelkz.gmapseta.app.model.Info;

import java.util.List;

public interface InfoRepositoryCustom {
    Info findTraffic(String id);

    Info findTraffic(String id,String position);

    Info findBestRoute(Integer origin);

    List<Info> findAllTraffic(Integer origin);
}
