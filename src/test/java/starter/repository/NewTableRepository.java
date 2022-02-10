package starter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import starter.entities.NewTable;

@Repository
public interface NewTableRepository extends CrudRepository<NewTable, Long> {

}
