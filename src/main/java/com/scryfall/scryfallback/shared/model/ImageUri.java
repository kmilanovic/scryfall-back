package com.scryfall.scryfallback.shared.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageUri {
    private String small;
    private String normal;
    private String large;
    private String png;
    private String art_crop;
    private String border_crop;
}
