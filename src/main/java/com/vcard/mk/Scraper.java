package com.vcard.mk;

import com.google.gson.Gson;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.property.Address;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Scraper {

    public String toVCard(String name, String telephone, String email, String website, String street, String postalCode, String city) {
        VCard vcard = new VCard();
        Address address = new Address();
        address.setPostalCode(postalCode);
        address.setStreetAddress(street);
        address.setRegion(city);
        vcard.setFormattedName(name);
        vcard.addTelephoneNumber(telephone);
        vcard.addEmail(email);
        vcard.addUrl(website);
        vcard.addAddress(address);
        return Ezvcard.write(vcard).version(VCardVersion.V4_0).go();
    }

    public String getCompanies(String query) throws IOException {
        StringBuilder result = new StringBuilder("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "</head>\n" +
                "<body>");

        Document document = Jsoup.connect("https://panoramafirm.pl/" + query).get();
        Elements elements = document.select("script[type=\"application/ld+json\"]");
        elements.remove(elements.last());

        for (Element element : elements) {
            Gson gson = new Gson();
            Response response = gson.fromJson(element.html(), Response.class);
            String params = String.format("name=%s&telephone=%s&email=%s&website=%s&street=%s&postalCode=%s&city=%s",
                    response.name, response.telephone, response.email, response.sameAs, response.address.streetAddress, response.address.postalCode, response.address.addressLocality).replaceAll(" ", "%20");

            result.append(String.format("<div>\n" +
                            "    <p><b>%s</b></p>\n" +
                            "    <p><img src=\"%s\" alt=\"logo firmy\"></img>\n" +
                            "    <p>Telefon: %s</p>\n" +
                            "    <p>Adres e-mail: %s</p>\n" +
                            "    <p>Strona internetowa: %s</p>\n" +
                            "  \n" +
                            "    <p>%s</p>\n" +
                            "    <p>%s</p>\n" +
                            "    <p>%s</p>\n" +
                            "    <p>" +
                            "<a href=/api/v1/vcard/?%s>" +
                            "<button>Generuj vCard</button></a></p>\n" +
                            "  </div><br/><br/>",
                    response.name, response.image, response.telephone, response.email, response.sameAs, response.address.streetAddress, response.address.postalCode, response.address.addressLocality, params));
        }

        return result.append("</body></html>").toString();
    }
}