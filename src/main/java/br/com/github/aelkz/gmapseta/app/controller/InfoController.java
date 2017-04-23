package br.com.github.aelkz.gmapseta.app.controller;

import br.com.github.aelkz.gmapseta.app.model.Info;
import br.com.github.aelkz.gmapseta.app.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoRepository infoRepository;

    @RequestMapping(method = RequestMethod.GET, value="/{routeId}")
    public Info getRouteTrafficData(@PathVariable("routeId") String routeId){
        return infoRepository.findTraffic(routeId);
    }

    @RequestMapping(method = RequestMethod.GET, value="/{routeId}")
    public Info getRouteTrafficData(@PathVariable("routeId") String routeId, @MatrixVariable("loc") String location){
        return infoRepository.findTraffic(routeId);
    }

}
