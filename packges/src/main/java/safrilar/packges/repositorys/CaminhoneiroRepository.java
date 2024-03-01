package safrilar.packges.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import safrilar.packges.models.CaminhoneiroModel;

public interface CaminhoneiroRepository extends JpaRepository<CaminhoneiroModel, Long> {
}
