package br.com.fiap.wallet.model.coins;

import br.com.fiap.wallet.cache.CryptoPriceCache;

import java.util.ArrayList;
import java.util.List;

public class CoinCrypto {

    private CurrencyPair currencyPair;
    private final String currencyBase = "brl";

    private double coinPrice = -1;

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public List<CoinCrypto> getAllPair(){
        List<CoinCrypto> allPair = new ArrayList<>();
        for (CurrencyPair pair : CurrencyPair.values()) {
            CoinCrypto coin = new CoinCrypto(pair);
            coin.fetchPrices(CryptoPriceCache.getInstance()); // usa cache para buscar o valor
            allPair.add(coin);   // adiciona na lista
        }
        return allPair;
    }

    public CoinCrypto(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public CoinCrypto(){}
    public void fetchPrices(CryptoPriceCache cache) {
        this.coinPrice = cache.getPrice(currencyPair.getSymbol(), currencyBase);
    }

    public double getCoinPrice() {
        return coinPrice;
    }

    public String getCurrencyBase() {
        return currencyBase.toUpperCase();
    }

    public String coinData() {
        return "PRECO do " + currencyPair.getSymbol().toUpperCase() + " em " + currencyBase.toUpperCase() + ": " + getCoinPrice();
    }
}