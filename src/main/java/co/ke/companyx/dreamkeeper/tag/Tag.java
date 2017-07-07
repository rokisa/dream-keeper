package co.ke.companyx.dreamkeeper.tag;

import co.ke.companyx.dreamkeeper.core.BaseEntity;
import co.ke.companyx.dreamkeeper.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by onyangor on 7/7/2017.
 */
@Entity
public class Tag extends BaseEntity {

    @NotNull
    @Size(min=2, max = 15)
    private String name;

    @ManyToOne
    private User owner;

    protected  Tag(){
        super();
    }

    public Tag(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
