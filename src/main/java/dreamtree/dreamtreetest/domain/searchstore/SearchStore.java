package dreamtree.dreamtreetest.domain.searchstore;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter @Setter
public class SearchStore {
    private String name;

    public SearchStore(){}
    public SearchStore(String name) {
        this.name = name;
    }
}
