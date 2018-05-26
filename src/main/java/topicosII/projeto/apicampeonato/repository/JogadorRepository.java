package topicosII.projeto.apicampeonato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topicosII.projeto.apicampeonato.model.Jogador;

import java.util.List;

@Repository
public  interface JogadorRepository extends JpaRepository<Jogador,Integer> {
    Jogador findByNome(String nome);
}
