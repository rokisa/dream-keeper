package co.ke.companyx.dreamkeeper.core;

import javax.persistence.*;

/**
 * Created by onyangor on 7/7/2017.
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
