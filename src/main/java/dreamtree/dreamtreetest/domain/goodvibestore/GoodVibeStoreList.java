package dreamtree.dreamtreetest.domain.goodvibestore;

import dreamtree.dreamtreetest.domain.store.Store;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoodVibeStoreList extends MongoRepository<GoodVibeStore,String> {
    public List<GoodVibeStore> findByLocationNear(Point location, Distance distance);
}
