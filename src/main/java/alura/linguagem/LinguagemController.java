package alura.linguagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

//    @GetMapping("/linguagem-preferida")
//    public String processaLinguagemPreferida() {
//        return "OI, JAVA!";
//    }

//        private List<Linguagem> linguagens =
//                List.of(
//                        new Linguagem("Java", "https://brasilcloud.com.br/wp-content/themes/brasilwork/img/destaque-host-java-servers.png", 1),
//                        new Linguagem("Python", "https://www.richgarcia.com.br/wp-content/uploads/2021/10/python-1536x650.png", 2)
//                );

    @GetMapping("/obter-linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repository.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repository.save(linguagem);
        return linguagemSalva;
    }


}
