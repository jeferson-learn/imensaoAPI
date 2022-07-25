package alura.filme;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HHTP e buscar os top 250 filmes

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = (ExtratorDeConteudo) new ExtratorDeConteudoDoIMDB();

//        String url = "https://api.mocki.io/v2/549a5d8b";
//        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

//        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
//        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

//        URI endereco = URI.create(url2);
//        var client = HttpClient.newHttpClient();
//        var request = HttpRequest.newBuilder(endereco).GET().build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        String body = response.body();
//        // System.out.println(body);

        var clienteHttp = new ClienteHttp();
//        clienteHttp.buscaDados(urlNASA); /** pode direto linha 35 e/ou 44**/
//        String json = clienteHttp.buscaDados(url10);
//        String json = clienteHttp.buscaDados(urlNASA);
        String json = clienteHttp.buscaDados(url);

        System.out.println("-------------------------------");

        /** - extrair só os dados que interessam (titulo, poster, classificação)
         - transferencia para classe ExtratorDeConteudoDaNasa **/
//        var parser = new JsonParser();
//        List<Map<String, String>> listaDeConteudos = parser.parse(body); /* 1 lvl */
//        List<Map<String, String>> listaDeConteudos = parser.parse(clienteHttp.buscaDados(url2)); /* 2 lvl */ /** OU **/
//        List<Map<String, String>> listaDeConteudos = parser.parse(clienteHttp.buscaDados(json));

//        System.out.println(listaDeConteudos.size());
//        System.out.println(listaDeConteudos.get(1));

        /** exibir e manipular os dados **/
//         var extrator = new ExtratorDeConteudoDaNasa();
//        ExtratorDeConteudoDaNasa extratorNASA = new ExtratorDeConteudoDaNasa();
//        List<Conteudo> conteudos = extratorNASA.extraiConteudos(json);

//        ExtratorDeConteudoDoIMDB extratorIMDB = new ExtratorDeConteudoDoIMDB();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradorDeFigurinhas();

//        for (Map<String, String> filme : listaDeConteudos) {
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }
}
