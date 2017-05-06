package br.com.github.aelkz.gmapseta.app.controller;

import br.com.github.aelkz.gmapseta.app.model.Info;
import br.com.github.aelkz.gmapseta.app.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "http://localhost:8100")
public class InfoController {

    @Autowired
    private InfoRepository infoRepository;

    @RequestMapping(method = RequestMethod.GET, value="/{routeId}")
    public Info getRouteTrafficData(@PathVariable("routeId") String routeId){
        return infoRepository.findTraffic(routeId);
    }

    @RequestMapping(method = RequestMethod.GET, value="/{routeId}/{userLocation}")
    public Info getRouteTrafficData(@PathVariable("routeId") String routeId, @MatrixVariable("userLocation") String location){
        return infoRepository.findTraffic(routeId);
    }

    @RequestMapping(method = RequestMethod.GET, value="/best/{origin}")
    public Info getBestRoute(@PathVariable("origin") Integer origin){
        return infoRepository.findBestRoute(origin);
    }

}
