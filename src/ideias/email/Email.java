package ideias.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

    public void enviarEmail() throws EmailException {

        SimpleEmail email = new SimpleEmail();
        //Utilize o hostname do seu provedor de email
        System.out.println("alterando hostname...");
        email.setHostName(hostName);
        //Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(smptPort);
        //Adicione os destinatários
        email.addTo(destinatario, nomeDestinatario);
        //Configure o seu email do qual enviará
        email.setFrom(login, nomeRemetente);
        //Adicione um assunto
        email.setSubject(assunto);
        //Adicione a mensagem do email
        email.setMsg(mensagem);
        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
        System.out.println("autenticando...");
        email.setSSL(true);
        email.setAuthentication(login, senha);
        System.out.println("enviando...");
        email.send();
        System.out.println("Email enviado!");
    }

    private String login = "cgcdoss1@gmail.com";
    private String senha = "gabi040697";
    private String nomeRemetente;
    private String assunto;
    private String mensagem;
    private String destinatario;
    private String nomeDestinatario;
    private String hostName = "smtp.gmail.com";
    private int smptPort = 465;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getSmptPort() {
        return smptPort;
    }

    public void setSmptPort(int smptPort) {
        this.smptPort = smptPort;
    }

}
