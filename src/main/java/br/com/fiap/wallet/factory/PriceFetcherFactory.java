package br.com.fiap.wallet.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.fiap.wallet.exception.FetcherErr;
import org.json.JSONObject; //precisa ajustar o arquivo .jar e importar de https://repo1.maven.org/maven2/org/json/json/20250107/
public class PriceFetcherFactory {

    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price"; //gerando uma constante com a API da coinGecko

    public static double getCryptoPrice(String crypto, String coinConvert){
        try{

            String urlString = API_URL + "?ids=" + crypto + "&vs_currencies=" + coinConvert; //Monta a url completa, exemplo https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Abre a conexao com a HTTP com a API
            connection.setRequestMethod("GET"); //Definindo o tipo da requisicao, somente busca pode ser GET

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //le a resposta da API
            StringBuilder resp = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null){
                resp.append(line);
            }
            reader.close();

            JSONObject jsonResp = new JSONObject(resp.toString());//criamos o objeto JSObjeto com a resposta da API
            return jsonResp.getJSONObject(crypto).getDouble(coinConvert); //retorna preco extraido do JSON
        }catch (FetcherErr | IOException e){ //valida se ocorrer erro
            System.err.println("Erro ao obter valor de alguma moeda!");
            return -1;
        }
    }
}
