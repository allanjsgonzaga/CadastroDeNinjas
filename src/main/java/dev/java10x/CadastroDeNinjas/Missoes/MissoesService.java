package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private final MissaoRepository missaoRepository;
    public MissoesService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //Cria uma nova missão no BD
    public MissaoModel criarMissao(MissaoModel missaoModel) {
        return missaoRepository.save(missaoModel);
    }

    //Retorna a lista de todas as missões no BD
    public List<MissaoModel> listarMissoes() {
        return missaoRepository.findAll();
    }

    //Busca uma missão por ID no BD, se achar retorna ela se não retorna null
    public MissaoModel buscarMissaoPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    //Deleta uma missão do BD pelo ID
    public void deleteMissao(Long id) {
        missaoRepository.deleteById(id);
    }

}
