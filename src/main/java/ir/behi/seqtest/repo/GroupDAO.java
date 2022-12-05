package ir.behi.seqtest.repo;

import ir.behi.seqtest.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GroupDAO extends CrudRepository<GroupEntity,Long> {
}
