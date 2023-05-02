package com.scryfall.scryfallback.shared.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Preview {
    private String source;
    private String source_uri;
    private Date previewed_at;
}
