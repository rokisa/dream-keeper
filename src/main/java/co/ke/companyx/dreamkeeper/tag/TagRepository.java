package co.ke.companyx.dreamkeeper.tag;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by onyangor on 7/7/2017.
 */
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @tagRepository.findOne(#id)?.owner?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #tag.owner?.username == authentication.name")
    void delete(@Param("tag") Tag tag);
}
