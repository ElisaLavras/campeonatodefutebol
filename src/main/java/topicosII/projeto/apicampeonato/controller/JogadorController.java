package topicosII.projeto.apicampeonato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import topicosII.projeto.apicampeonato.model.Jogador;
import topicosII.projeto.apicampeonato.service.JogadorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/jogador")
public class JogadorController {
    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public ResponseEntity<Jogador> cria(@Validated @RequestBody Jogador jogador){
        Jogador jogadorSalvo = jogadorService.salva(jogador);

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequestUri().
                path("/{id}").
                buildAndExpand(jogadorSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(jogadorSalvo);
    }

    @GetMapping
    public  ResponseEntity<?> listaJogadores(){
        List<Jogador> jogadores = jogadorService.todos();
        if (jogadores.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(jogadores);
        }
    }

    @GetMapping("/{id}")
    public Jogador buscarPor(@PathVariable Integer id){
        return jogadorService.buscaPor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void excluir(@PathVariable Integer id) {
        jogadorService.excluir(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Integer id,
                                               @Validated @RequestBody Jogador jogador ) {

        Jogador jogadorManager = jogadorService.atualiza(id, jogador );
        return ResponseEntity.ok(jogadorManager );
    }
}
