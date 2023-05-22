package dreamtree.dreamtreetest;

import dreamtree.dreamtreetest.domain.store.AllStoreList;
import dreamtree.dreamtreetest.domain.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.awt.*;
import java.util.List;

@SpringBootApplication
public class DreamtreetestApplication {
	@Autowired
	AllStoreList allStoreList;
	public static void main(String[] args) {
		SpringApplication.run(DreamtreetestApplication.class, args);
	}



}
