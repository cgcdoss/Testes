/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.cep;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Cássio Gabriel
 */
public class QualOCep {

    public String getEndereco(String CEP) throws IOException {
String endereco = "";
        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
            for (Element urlEndereco : urlPesquisa) {
                endereco = urlEndereco.text();
                return urlEndereco.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return endereco;
    }

    public String getBairro(String CEP) throws IOException {
        String bairro = "";
        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("td:gt(1)");
            for (Element urlBairro : urlPesquisa) {
                bairro = urlBairro.text();
                return urlBairro.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return bairro;
    }

    public String getCidade(String CEP) throws IOException {
        String cidade = "";
        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
            for (Element urlCidade : urlPesquisa) {
                cidade = urlCidade.text();
                return urlCidade.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return cidade;
    }

    public String getUF(String CEP) throws IOException {
        String uf = "";
        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");

            for (Element urlUF : urlPesquisa) {
                uf = urlUF.text();
                return urlUF.text();
            }
        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return uf;
    }

    public String getLatLong(String CEP) throws IOException, ParseException {

        // ***************************************************
        try {

            if (CEP.contains("-")) {
                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                + CEP + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            } else {

                StringBuilder cepHif = new StringBuilder(CEP);
                cepHif.insert(CEP.length() - 3, '-');

                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                + cepHif + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }

}
