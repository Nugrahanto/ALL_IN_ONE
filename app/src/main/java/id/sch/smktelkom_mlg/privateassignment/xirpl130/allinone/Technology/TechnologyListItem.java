package id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.Technology;

import java.io.Serializable;

/**
 * Created by Nugrahanto on 12/05/2017.
 */

public class TechnologyListItem implements Serializable {
    //    private String imageUrl;
    private String head;
    private String desc;

    public TechnologyListItem(String head, String desc) {
//        this.imageUrl = imageUrl;
        this.head = head;
        this.desc = desc;
    }

//    public String getImageUrl() {
//        return imageUrl;
//    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
