package co.ke.companyx.dreamkeeper.dream;

import co.ke.companyx.dreamkeeper.tag.Tag;
import co.ke.companyx.dreamkeeper.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Date;

/**
 * Created by onyangor on 7/7/2017.
 */
public interface DreamRepository extends PagingAndSortingRepository<Dream, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @dreamRepository.findOne(#id)?.dreamer?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #dream.dreamer?.username == authentication.name")
    void delete(@Param("dream") Dream dream);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #dream.dreamer?.username == authentication.name")
    void deleteAll();

    @Override
    @PreAuthorize("#dream.dreamer?.username == authentication.name")
    Dream save(@Param("dream") Dream dream);

   // @RestResource(rel = "tag-equals", path = "equalsTag")
    Page<Dream> findByTagAndDreamer(@Param("tag") Tag tag, @Param("dreamer") User dreamer, Pageable page);

    //@RestResource(rel = "description-contains", path = "containsDescription")
    Page<Dream> findByDescriptionContainingAndDreamer(@Param("description") String keywords, @Param("dreamer") User dreamer, Pageable page);

   // @RestResource(rel = "night-equals", path = "containsNight")
    Page<Dream> findByNightAndDreamer(@Param("night") Date night, @Param("dreamer") User dreamer, Pageable page);

    Page<Dream> findByTagAndNightAndDreamer(@Param("tag") Tag tag,
                                                @Param("night") Date night, @Param("dreamer") User dreamer, Pageable page);
    @Override
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    Page<Dream> findAll(Pageable page);
}