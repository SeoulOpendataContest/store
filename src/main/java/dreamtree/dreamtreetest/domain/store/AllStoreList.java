package dreamtree.dreamtreetest.domain.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public interface AllStoreList extends MongoRepository<Store,String>{
        public Store findByname(String name);
        public List<Store> findByLocationNear(Point location, Distance distance);
        public List<Store> findAllByNameEndsWith(String name);
        public List<Store> findAllByNameStartsWith(String name);

}
