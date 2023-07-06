package com.scryfall.scryfallback.pages.set.controller;

import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.dto.SetIconDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;
import com.scryfall.scryfallback.pages.set.service.SetService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/set")
public class SetController {

    private final SetService setService;

    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping("/all-api")
    public SetWrapper getAllSetsFromAPI() {
        return setService.getAllSetsFromAPI();
    }

    @GetMapping("/all-paginated")
    public Page<SetDTO> getAllSets(
            @RequestHeader("userId") Long userId,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize) {
        return setService.getAllSets(userId, pageIndex, pageSize);
    }

    @GetMapping("/all")
    public List<SetDTO> getAllSets(@RequestHeader("userId") Long userId) {
        return setService.getAllSets(userId);
    }

    @GetMapping("/set-icon/all")
    public List<SetIconDTO> getAllSetIcons() {
        return setService.getAllSetIcons();
    }

    @PostMapping("/add")
    public Set addSet(@RequestBody Set set) {
        return setService.addSet(set);
    }

    @DeleteMapping("{id}")
    public void deleteSet(@PathVariable Long id) {
        setService.deleteSet(id);
    }

    @DeleteMapping("/{setId}/card/{cardId}")
    public void deleteCardFromSet(
            @PathVariable Long setId,
            @PathVariable Long cardId) {
        setService.deleteCardFromSet(setId, cardId);
    }
}
