package safrilar.packges.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safrilar.packges.models.PagamentoModel;
@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> {
}
