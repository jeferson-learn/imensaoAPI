package alura.filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements com.alura.ExtratorDeConteudo {

    public List<com.alura.Conteudo> extraiConteudos (String json) {
        /** extrair só os dados que interessam (titulo, poster, classificação) **/
        var parser = new com.alura.JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<com.alura.Conteudo> conteudos = new ArrayList<>();

        /** popular a lista de conteudos **/
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title").replace(":", "-");
            String urlImagem = atributos.get("url");
            var conteudo = new com.alura.Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }

}
