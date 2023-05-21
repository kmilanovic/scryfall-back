package com.scryfall.scryfallback.pages.set.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Set {

    private String object;
    private String id;
    private String code;
    private String name;
    private String tcgplayer_id;
    private String scryfall_uri;
    private String search_uri;
    private String released_at;
    private String set_type;
    private String card_count;
    private String digital;
    private String nonfoil_only;
    private String foil_only;
    private String icon_svg_uri;
}
