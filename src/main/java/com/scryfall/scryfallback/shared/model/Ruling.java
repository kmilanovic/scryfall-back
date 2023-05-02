package com.scryfall.scryfallback.shared.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ruling {
    private String object;
    private String oracle_id;
    private String source;
    private Date published_at;
    private String comment;
}
