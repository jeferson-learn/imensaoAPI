package alura.linguagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagem() {
        List<Linguagem> linguagens = repository.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repository.save(linguagem);
        return linguagemSalva;
    }

    @DeleteMapping("/linguagens/{id}")
    public void apagarLinguagem(@PathVariable String id){
        repository.deleteById(id);
    }

//    @PutMapping("/linguagens/{id}")
//    public String atualizarLinguagem(@PathVariable String id){
//        repository.
//    }
//public LanguageResponse updateLanguage(String id, LanguageUpdateRequest request) {
//    var result = repository.findById(id);
//
//    if(result.isEmpty()) {
//        throw new LanguageNotFoundException();
//    }
//
//    var language = result.get();
//    language.setImage(request.getImage());
//    language.setRanking(request.getRanking());
//    var saveLanguage = repository.save(language);
//
//    return new LanguageResponse(
//            saveLanguage.getId(),
//            saveLanguage.getTitle(),
//            saveLanguage.getImage(),
//            saveLanguage.getRanking()
//    );
//}


}
