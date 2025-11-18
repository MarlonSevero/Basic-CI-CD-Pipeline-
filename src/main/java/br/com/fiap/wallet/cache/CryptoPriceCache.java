package br.com.fiap.wallet.cache;
import br.com.fiap.wallet.factory.PriceFetcherFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe singleton responsável por armazenar em cache os preços de criptomoedas
 * para evitar chamadas desnecessárias à API externa (CoinGecko).
 */
public class CryptoPriceCache {

    // Tempo de validade do cache: 60 segundos
    private static final long CACHE_DURATION = 60 * 1000;

    // Instância única (singleton) da classe
    private static CryptoPriceCache instance;

    // Mapa para armazenar os preços em cache com a chave no formato "bitcoin_usd", por exemplo
    private final Map<String, CachedPrice> cache = new HashMap<>();

    // Construtor privado para evitar instância externa (padrão Singleton)
    private CryptoPriceCache() {}

    /**
     * Método público para acessar a instância única da classe.
     */
    public static synchronized CryptoPriceCache getInstance() {
        if (instance == null) {
            instance = new CryptoPriceCache();
        }
        return instance;
    }

    /**
     * Retorna o preço da criptomoeda usando cache se ainda estiver válido.
     * Se o cache expirou ou não existe, faz uma nova requisição à API.
     */
    public double getPrice(String crypto, String coinConvert) {
        String key = crypto + "_" + coinConvert;

        // Verifica se existe valor em cache e se ainda está válido
        CachedPrice cached = cache.get(key);
        if (cached != null && !cached.isExpired()) {
            return cached.getPrice(); // retorna do cache
        }

        // Se não existe ou expirou, consulta o valor na API
        double newPrice = PriceFetcherFactory.getCryptoPrice(crypto, coinConvert);

        // Armazena o novo valor no cache
        cache.put(key, new CachedPrice(newPrice));

        return newPrice;
    }

    /**
     * Classe interna usada para armazenar o preço e o tempo em que foi armazenado.
     */
    private static class CachedPrice {
        private final double price;
        private final long timestamp;

        public CachedPrice(double price) {
            this.price = price;
            this.timestamp = System.currentTimeMillis(); // marca o momento do cache
        }

        // Verifica se passou mais de 60 segundos desde que o valor foi salvo
        public boolean isExpired() {
            return System.currentTimeMillis() - timestamp > CACHE_DURATION;
        }

        public double getPrice() {
            return price;
        }
    }
}