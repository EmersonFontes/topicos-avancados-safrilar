package safrilar.packges.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safrilar.packges.models.UsuarioModel;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
