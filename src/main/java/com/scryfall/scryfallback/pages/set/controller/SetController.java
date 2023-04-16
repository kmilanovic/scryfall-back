package com.scryfall.scryfallback.pages.set.controller;

import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.service.SetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/set")
public class SetController {

    private final SetService setService;

    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping("/all")
    public List<SetDTO> getAllSets() {
       return setService.getAllSets();
    }

    @PostMapping("/add")
    public Set addSet(@RequestBody Set set) {
        return setService.addSet(set);
    }
}