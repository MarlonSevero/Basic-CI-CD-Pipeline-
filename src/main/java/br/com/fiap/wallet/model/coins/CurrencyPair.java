package br.com.fiap.wallet.model.coins;

public enum CurrencyPair {
    BITCOIN("bitcoin"),
    SOLANA("solana"),
    USDT("tether"),
    DOGE("dogecoin"),
    ETHEREUM("ethereum");
    
    public final String symbol;

    CurrencyPair(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CurrencyPair fromString(String text) {
        for (CurrencyPair pair : CurrencyPair.values()) {
            if (pair.symbol.equalsIgnoreCase(text)) {
                return pair;
            }
        }
        throw new IllegalArgumentException("No enum constant " + text);
    }
}