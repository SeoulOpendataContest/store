// package dreamtree.dreamtreetest.domain.store;
//
//
//
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.geo.Distance;
// import org.springframework.data.geo.Metrics;
// import org.springframework.data.geo.Point;
//
// import java.util.List;
//
// @SpringBootTest
// class AllStoreListTest {
//
//     @Autowired
//     AllStoreList allStoreList;
//     @Test
//     void findByLocationNear() {
//         Point p=new Point(127.058338066917,37.6193203481648);
//         Distance d = new Distance(1, Metrics.KILOMETERS);
//         System.out.println(allStoreList.findByname("일마일라대림1호점").getLocation());
//         List<Store> storeList=allStoreList.findByLocationNear(p,d);
//         for (Store store:storeList){
//             System.out.println(store.getName());
//         }
//     }
// }