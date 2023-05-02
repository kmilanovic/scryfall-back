package com.scryfall.scryfallback.shared;

import com.scryfall.scryfallback.pages.card.model.response.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
@Slf4j
public class ScryfallHandler {

    private final RestTemplate restTemplate;
    @Value("${scryfall.url}")
    protected String scryfallUrl;


    public ScryfallHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Card getCardById(Card card) {
        String url = scryfallUrl + card.getId();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<Card> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                Card.class
        );
        return responseEntity.getBody();
    }

    public RulingWrapper getCardRulings(Card card) {
        String url = scryfallUrl + card.getId() + "/rulings";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<RulingWrapper> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }

    public CardWrapper getCardsBySearch(SearchTerm searchTerm) {
        String url = scryfallUrl + "/search?order=cmc&q=" + searchTerm.getTerm();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<CardWrapper> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }
}
