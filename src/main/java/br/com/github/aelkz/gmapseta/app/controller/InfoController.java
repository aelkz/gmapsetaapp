package br.com.github.aelkz.gmapseta.app.controller;

import br.com.github.aelkz.gmapseta.app.model.Info;
import br.com.github.aelkz.gmapseta.app.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET, value="/status/{origin}")
    public List<Info> getRouteStatus(@PathVariable("origin") Integer origin){
        return infoRepository.findAllTraffic(origin);
    }

    @RequestMapping(method = RequestMethod.GET, value="/best/{origin}")
    public Info getBestRoute(@PathVariable("origin") Integer origin){
        return infoRepository.findBestRoute(origin);
    }

    // --------
    // weather: accuweather
    // --------
    // http://apidev.accuweather.com/developers

    // --------
    // weather: openweathermap
    // --------
    // https://openweathermap.org/current
    // 5b1502a400dd04ec17bf12a972c96c70
    // http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID={APIKEY}
    // http://api.openweathermap.org/data/2.5/weather?id=3447466&units=metric&appid=5b1502a400dd04ec17bf12a972c96c70

    /*
    "id": 3469058,
    "name": "Brasilia",
    "country": "BR",
    "coord": { "lon": -47.929722,"lat": -15.77972

    "id": 3447473,
    "name": "Sobradinho",
    "country": "BR",
    "coord": { "lon": -39.099998, "lat": -12.83333 }
    // -15.6531/-47.7914
    // http://api.openweathermap.org/data/2.5/weather?units=metric&lat=47.7914&lon=15.6531&appid=5b1502a400dd04ec17bf12a972c96c70
     */

}
