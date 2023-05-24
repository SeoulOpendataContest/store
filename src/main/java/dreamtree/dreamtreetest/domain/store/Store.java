package dreamtree.dreamtreetest.domain.store;

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

@Document(collection = "2dStorefinal")
@Getter @Setter
public class Store {
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
    @Field("storeurl")
    private String storeurl;
    @Field("storeaddress")
    private String storeaddress;

    public Store(String category, String name, double latitude, double longitude,GeoJsonPoint location,String storeurl,String storeaddress) {
        this.category = category;
        this.name = name;
        this.latitude=latitude;
        this.longitude=longitude;
        this.location = location;
        this.storeaddress=storeaddress;
        this.storeurl=storeurl;
    }
}
