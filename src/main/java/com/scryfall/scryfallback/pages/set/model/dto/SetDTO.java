package com.scryfall.scryfallback.pages.set.model.dto;

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
    private String name;
    private Long userId;

    public static List<SetDTO> fromEntityList(List<Set> setList) {
        return setList.stream().map(SetDTO::fromEntity).collect(Collectors.toList());
    }

    public static SetDTO fromEntity(Set s) {
        SetDTO setDTO = new SetDTO();
        setDTO.setName(s.getName());
        setDTO.setUserId(s.getUserId());
        return setDTO;
    }

    public Set toEntity() {
        Set s = new Set();
        s.setName(this.name);
        s.setUserId(this.userId);
        return s;
    }
}
