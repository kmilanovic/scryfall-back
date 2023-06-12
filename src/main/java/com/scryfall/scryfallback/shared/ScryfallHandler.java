package com.scryfall.scryfallback.shared;

import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.set.model.response.SetResponse;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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

    public CardResponse getCardById(CardResponse cardResponse) {
        String url = scryfallUrl + "cards/" + cardResponse.getId();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                CardResponse.class
        );
        return responseEntity.getBody();
    }

    public RulingWrapper getCardRulings(CardResponse cardResponse) {
        String url = scryfallUrl + "cards/" + cardResponse.getId() + "/rulings";
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
        if (searchTerm == null || searchTerm.getTerm().isEmpty()) {
            return new CardWrapper();
        }
        String url = scryfallUrl + "cards/" + "/search?order=cmc&q=" + searchTerm.getTerm();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);

        try {
            ResponseEntity<CardWrapper> responseEntity = restTemplate.exchange(
                    uriComponentsBuilder.encode().build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            return responseEntity.getBody();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new CardWrapper();
            } else {
                throw ex;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public SetWrapper getAllSets() {
        String url = scryfallUrl + "sets/";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<SetWrapper> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }

    public CardWrapper getCardsBySetCode(SetResponse setResponse) {
        String url = scryfallUrl + "cards/" + "/search?order=set&q=set:" + setResponse.getCode() + "&unique=prints";
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
