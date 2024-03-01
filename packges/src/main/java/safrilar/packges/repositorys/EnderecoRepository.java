package safrilar.packges.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safrilar.packges.models.EnderecoModel;
@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    public EnderecoModel findEnderecoModelByCep(String cep);
}
