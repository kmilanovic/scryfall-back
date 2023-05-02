package com.scryfall.scryfallback.shared.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    private String usd;
    private String usd_foil;
    private String usd_etched;
    private String eur;
    private String eur_foil;
    private String tix;
}
