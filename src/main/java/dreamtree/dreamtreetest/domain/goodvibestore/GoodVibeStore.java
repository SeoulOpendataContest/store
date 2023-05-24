package dreamtree.dreamtreetest.domain.goodvibestore;


import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "goodvibestorelistfinal")
@Getter @Setter
public class GoodVibeStore {
    @Field("category")
    private String category;
    @Field("name")
    private String name;
    @Field("latitude")
    private double latitude;
    @Field("longitude")
    private double longitude;
    @Field("location")
    private GeoJsonPoint location;
    @Field("benefit")
    private  String benefit;
    @Field("storeurl")
    private String storeurl;
    @Field("storeaddress")
    private String storeaddress;

    public GoodVibeStore(String category, String name, double latitude, double longitude,GeoJsonPoint location,String benefit,String storeurl,String storeaddress) {
        this.category = category;
        this.name = name;
        this.latitude=latitude;
        this.longitude=longitude;
        this.location = location;
        this.benefit=benefit;
        this.storeaddress=storeaddress;
        this.storeurl=storeurl;
    }
}
