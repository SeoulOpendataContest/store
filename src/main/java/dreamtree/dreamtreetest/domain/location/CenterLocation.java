package dreamtree.dreamtreetest.domain.location;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CenterLocation {
    private String longitude;
    private String latitude;
    private String distance;
    private String category;

    public CenterLocation(String longitude,String latitude, String distance,String category) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.category=category;
    }
}
