package topicosII.projeto.apicampeonato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    private  String genero;

    private Date nascimento;

    private Double altura;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public Double getAltura() {
        return altura;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}
