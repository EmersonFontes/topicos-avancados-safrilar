package safrilar.packges.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safrilar.packges.models.CargaModel;
@Repository
public interface CargaRepository extends JpaRepository<CargaModel, Long> {
}
