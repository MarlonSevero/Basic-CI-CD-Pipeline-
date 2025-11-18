package br.com.fiap.wallet.model.user;

public class Address {

    private int id;
    private String cidade;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;

    public Address(String cidade, String rua, String bairro, String numero, String complemento){
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Address(){

    }

    public Address(int id, String cidade, String rua, String bairro, String numero, String complemento) {
        this.id = id;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCidade() {return cidade;}

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public int getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public Address setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public Address setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public Address setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Address setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Address setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public Address setId(int id) {
        this.id = id;
        return this;
    }
}
