package co.ke.companyx.dreamkeeper.dream;

import co.ke.companyx.dreamkeeper.core.BaseEntity;
import co.ke.companyx.dreamkeeper.tag.Tag;
import co.ke.companyx.dreamkeeper.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by onyangor on 7/7/2017.
 */
@Entity
public class Dream extends BaseEntity {
    private String description;

    @ManyToOne
    private User dreamer;

    @OneToOne
    private Tag tag;

    private Date night;

    public Dream() {
        super();
    }

    public Dream(String description, User dreamer, Tag tag, Date night) {
        this.description = description;
        this.dreamer = dreamer;
        this.tag = tag;
        this.night = night;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getDreamer() {
        return dreamer;
    }

    public void setDreamer(User dreamer) {
        this.dreamer = dreamer;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Date getNight() {
        return night;
    }

    public void setNight(Date night) {
        this.night = night;
    }
}
