package safrilar.packges.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safrilar.packges.models.AgricultorModel;

@Repository
public interface AgricultorRepository extends JpaRepository<AgricultorModel, Long> {
}
