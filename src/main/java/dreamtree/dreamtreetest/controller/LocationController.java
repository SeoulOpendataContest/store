package dreamtree.dreamtreetest.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dreamtree.dreamtreetest.domain.location.MyLocation;
import dreamtree.dreamtreetest.domain.goodvibestore.GoodVibeStore;
import dreamtree.dreamtreetest.domain.goodvibestore.GoodVibeStoreList;
import dreamtree.dreamtreetest.domain.searchstore.SearchStore;
import dreamtree.dreamtreetest.domain.location.CenterLocation;
import dreamtree.dreamtreetest.domain.store.AllStoreList;
import dreamtree.dreamtreetest.domain.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    AllStoreList allStoreList;
    @Autowired
    GoodVibeStoreList goodVibeStoreList;

    @ResponseBody
    @RequestMapping(value = "/find")
    public String findStoreList(@RequestBody CenterLocation centerLocation) throws JsonProcessingException {
        double longitude= Double.parseDouble(centerLocation.getLongitude());//경도
        double latitude= Double.parseDouble(centerLocation.getLatitude());//위도
        double distance= Double.parseDouble(centerLocation.getDistance());
        String category= centerLocation.getCategory();//km단위 거리
        List<Store> store = allStoreList.findByLocationNear(new Point(longitude, latitude), new Distance(distance, Metrics.KILOMETERS));
        if(!category.equals("all")){
            store=store.stream().filter(s-> s.getCategory().equals(category)).collect(Collectors.toList());
        }

        ObjectMapper objectMapper=new ObjectMapper();
        String storeListJson=objectMapper.writeValueAsString(store);
        return storeListJson;

    }

    @ResponseBody
    @RequestMapping(value = "/namesearch")
    public String searchStoreList(@RequestBody SearchStore searchStore) throws JsonProcessingException {

        String searchName = searchStore.getName();
        List<Store> startsWithStore=allStoreList.findAllByNameStartsWith(searchName);
        List<Store> endsWithStore=allStoreList.findAllByNameEndsWith(searchName);
        startsWithStore.addAll(endsWithStore);

        ObjectMapper objectMapper=new ObjectMapper();
        String storeListJson=objectMapper.writeValueAsString(startsWithStore);
        return storeListJson;

    }

    @ResponseBody
    @RequestMapping(value = "/goodvibestorefind")
    public String findGoodVibeStoreList(@RequestBody CenterLocation centerLocation) throws  JsonProcessingException{
        double longitude= Double.parseDouble(centerLocation.getLongitude());//경도
        double latitude= Double.parseDouble(centerLocation.getLatitude());//위도
        double distance= Double.parseDouble(centerLocation.getDistance());//km단위 거리
        String category=centerLocation.getCategory();
        List<GoodVibeStore> store =goodVibeStoreList.findByLocationNear(new Point(longitude, latitude), new Distance(distance, Metrics.KILOMETERS));
        if(!category.equals("all")){
            store=store.stream().filter(s-> s.getCategory().equals(category)).collect(Collectors.toList());
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String storeListJson=objectMapper.writeValueAsString(store);
        return storeListJson;
    }

    @ResponseBody
    @RequestMapping(value ="/mylocation")
    public String getMyLocation(@RequestBody MyLocation myLocation) throws JsonProcessingException{
        String myLocationJson=myLocation.findMyAddress();
        return myLocationJson;

    }



}
