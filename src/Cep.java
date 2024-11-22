public class Cep {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Cep(InformacoesCep minhasInformacoesCep) {
        this.logradouro = minhasInformacoesCep.logradouro();
        this.complemento = minhasInformacoesCep.complemento();
        this.bairro = minhasInformacoesCep.bairro();
        this.localidade = minhasInformacoesCep.localidade();
        this.uf = minhasInformacoesCep.uf();
    }

    @Override
    public String toString() {
        return "Logradouro: " + logradouro + ", Complemento: " + complemento + ", Bairro: " + bairro + ", Localidade: " + localidade + ", UF: " + uf;
    }
}
