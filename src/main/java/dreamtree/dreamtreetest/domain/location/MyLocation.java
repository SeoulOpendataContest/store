package dreamtree.dreamtreetest.domain.location;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class MyLocation {
    static final String KEY="f96d18308bf5584c62397cace8311724";
    private String longitude;
    private String latitude;
    private String Myaddress;
    public MyLocation(String longitude,String latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public String findMyAddress() throws JsonProcessingException {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String appKey = "KakaoAK " + KEY;
        headers.set("Authorization", appKey);
        Double lat = Double.parseDouble(latitude);
        Double lon = Double.parseDouble(longitude);
        String url = "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=" +  lon+ "&y=" + lat+"&=input_coord=WGS84";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(result.getBody());
        JsonNode documentsNode = responseJson.path("documents");
        String addressName = documentsNode.get(0).path("address_name").asText();
        Map<String, String> jsonmap = new HashMap<>();
        jsonmap.put("address_name", addressName);
        String jsonResult = objectMapper.writeValueAsString(jsonmap);
        return jsonResult;



    }
}
