package com.vcard.mk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1")
public class RestAPI {

    @Autowired
    Scraper scraper;

    @GetMapping("/{companyToSearch}")
    public String getCompanies(@PathVariable String companyToSearch) throws IOException {
        return scraper.getCompanies(companyToSearch);
    }

    @GetMapping(value = "/vcard/", produces = {"text/vcard"})
    public String getCompanyVCard(@RequestParam String name, @RequestParam String telephone, @RequestParam String email, @RequestParam String website, @RequestParam String street, @RequestParam String postalCode, @RequestParam String city) {
        return scraper.toVCard(name, telephone, email, website, street, postalCode, city);
    }
}
