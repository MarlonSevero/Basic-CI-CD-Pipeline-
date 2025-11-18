package br.com.fiap.wallet.model.user;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Account {

    private String name;
    private LocalDate dt_birth;
    private double renda;
    private String cpf;
    private int id_address;
    private String email;
    private String password;

    public Account(String name, LocalDate dt_birth, double renda, String cpf, String email, String password){
        this.name = name;
        this.dt_birth = dt_birth;
        this.renda = renda;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public Account(String name, LocalDate dt_birth, double renda, String cpf, String email, String password, int id_address){
        this.name = name;
        this.dt_birth = dt_birth;
        this.renda = renda;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.id_address = id_address;
    }

    public Account(){

    }


    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDt_birth() {
        return dt_birth;
    }

    public String getDt_Formatted(){ /*metodo para formatar a data nascimento padrao brasil*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt_birth.format(formatter);
    }

    public void setDt_birth(LocalDate dt_birth){ /*setter para setar a data de nascimento*/
        this.dt_birth = dt_birth;
    }

    public double getRenda() {
        return renda;
    }

    public Account setRenda(double renda) {
        this.renda = renda;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Account setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public int getId_address() {
        return id_address;
    }

    public Account setId_address(int id_address) {
        this.id_address = id_address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }
}
