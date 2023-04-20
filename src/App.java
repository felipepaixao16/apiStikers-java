// Consumindo uma API de Filmes da IMDB

import java.io.InputStream;
import java.net.URL;
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
        //ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();


        String url = "https://api.nasa.gov/planetary/apod?api_key=spBQEUdMeKSoHAZN73evOmuKfiIzqDpzTWpanKrF&start_date=2022-05-12&end_date=2022-05-14";
        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

        //String url = "http://localhost:8080/linguagens";
        //ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "C:/Users/Felip/Desktop/alura/apiStikers-java/saida/" + conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();

            // transformando uma String em Int.

            //int estrelas = Integer.parseInt(estrela);
            // System.out.println(estrelas);

        }

    }
}
