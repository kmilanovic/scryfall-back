package com.scryfall.scryfallback.pages.set.model.dto;

import com.scryfall.scryfallback.pages.card.model.dto.CardDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SetDTO {
    private Long set_id;

    private String object;
    private String id;
    private String code;
    private String name;
    private String tcgplayer_id;
    private String scryfall_uri;
    private String search_uri;
    private String released_at;
    private String set_type;
    private String digital;
    private String nonfoil_only;
    private String foil_only;
    private String icon_svg_uri;
    private Long user_id;
    private List<CardDTO> cards;

    public static List<SetDTO> fromEntityList(List<Set> setList, Long userId) {
        return setList.stream()
                .filter(s -> s.getUser_id().equals(userId))
                .map(SetDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public static SetDTO fromEntity(Set s) {
        SetDTO setDTO = new SetDTO();
        setDTO.setSet_id(s.getSet_id());
        setDTO.setObject(s.getObject());
        setDTO.setId(s.getId());
        setDTO.setCode(s.getCode());
        setDTO.setName(s.getName());
        setDTO.setTcgplayer_id(s.getTcgplayer_id());
        setDTO.setScryfall_uri(s.getScryfall_uri());
        setDTO.setSearch_uri(s.getSearch_uri());
        setDTO.setReleased_at(s.getReleased_at());
        setDTO.setSet_type(s.getSet_type());
        setDTO.setDigital(s.getDigital());
        setDTO.setNonfoil_only(s.getNonfoil_only());
        setDTO.setFoil_only(s.getFoil_only());
        setDTO.setIcon_svg_uri(s.getIcon_svg_uri());
        setDTO.setUser_id(s.getUser_id());
        setDTO.setCards(CardDTO.fromEntityList(s.getCards()));
        return setDTO;
    }

    public Set toEntity() {
        Set s = new Set();
        s.setObject(this.object);
        s.setId(this.id);
        s.setCode(this.code);
        s.setName(this.name);
        s.setTcgplayer_id(this.tcgplayer_id);
        s.setScryfall_uri(this.scryfall_uri);
        s.setSearch_uri(this.search_uri);
        s.setReleased_at(this.released_at);
        s.setSet_type(this.set_type);
        s.setDigital(this.digital);
        s.setNonfoil_only(this.nonfoil_only);
        s.setFoil_only(this.foil_only);
        s.setIcon_svg_uri(this.icon_svg_uri);
        s.setUser_id(this.user_id);
        // Set cards property if available
        //s.setCards(this.cards);
        return s;
    }
}
