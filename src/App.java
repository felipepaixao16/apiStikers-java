// Consumindo uma API de Filmes da IMDB

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 3 filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        String url = "https://api.nasa.gov/planetary/apod?api_key=spBQEUdMeKSoHAZN73evOmuKfiIzqDpzTWpanKrF&start_date=2022-05-12&end_date=2022-05-14";

        // pegar só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(body);

        // exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 3; i++) {

            Map<String,String> conteudo = listaDeConteudos.get(i);

            String urlImagem = conteudo.get("url").replaceAll("(@+)(.*).jpg$", "$1.jpg");

            String titulo = conteudo.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "C:/Users/Felip/Desktop/alura/apiStikers-java/saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();

            // transformando uma String em Int.

            //int estrelas = Integer.parseInt(estrela);
            // System.out.println(estrelas);

        }

    }
}
