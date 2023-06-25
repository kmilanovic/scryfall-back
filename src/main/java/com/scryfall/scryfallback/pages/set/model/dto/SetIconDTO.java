package com.scryfall.scryfallback.pages.set.model.dto;

import com.scryfall.scryfallback.pages.set.model.entity.SetIcon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetIconDTO {
    private long id;
    private String name;
    private String icon_path;

    public static List<SetIconDTO> fromEntityList(List<SetIcon> setList) {
        return setList.stream()
                .map(SetIconDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public static SetIconDTO fromEntity(SetIcon si) {
        SetIconDTO setIconDTO = new SetIconDTO();
        setIconDTO.setId(si.getId());
        setIconDTO.setName(si.getName());
        setIconDTO.setIcon_path(si.getIcon_path());
        return setIconDTO;
    }
}
