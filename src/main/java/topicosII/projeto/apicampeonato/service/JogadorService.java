package topicosII.projeto.apicampeonato.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import topicosII.projeto.apicampeonato.model.Jogador;
import topicosII.projeto.apicampeonato.repository.JogadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Transactional
    public Jogador salva(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    @Transactional
    public List<Jogador> todos(){
        return jogadorRepository.findAll();
    }


    public Jogador buscaPor(Integer id){
        return jogadorRepository.findById(id).orElseThrow(() ->new EmptyResultDataAccessException(1));
    }

    @Transactional
    public Jogador atualiza(Integer id, Jogador jogador){
        Jogador jogadorManager = this.buscaPor(id);
        BeanUtils.copyProperties(jogador, jogadorManager, "id");
        this.salva(jogadorManager);
        return jogadorManager;
    }

    @Transactional
    public void excluir(Integer id) {
        jogadorRepository.deleteById(id );
    }
}
