package com.scryfall.scryfallback.shared;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.model.request.CardRequest;
import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.request.SetRequest;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;
import com.scryfall.scryfallback.pages.set.repository.SetRepository;
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
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class ScryfallHandler {

    private final RestTemplate restTemplate;
    private final SetRepository setRepository;
    @Value("${scryfall.url}")
    protected String scryfallUrl;


    public ScryfallHandler(RestTemplate restTemplate, SetRepository setRepository) {
        this.restTemplate = restTemplate;
        this.setRepository = setRepository;
    }

    public CardResponse getCardById(CardRequest cardRequest) {
        String url = scryfallUrl + "cards/" + cardRequest.getId();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                CardResponse.class
        );
        return responseEntity.getBody();
    }

    public RulingWrapper getCardRulings(CardRequest cardRequest) {
        String url = scryfallUrl + "cards/" + cardRequest.getId() + "/rulings";
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

    public CardWrapper getCardsBySetCode(SetRequest setRequest) {
        String url = scryfallUrl + "cards/" + "/search?order=set&q=set:" + setRequest.getCode() + "&unique=prints";
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

    public List<CardResponse> getRandomCard() {
        String url = scryfallUrl + "cards/random";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                uriComponentsBuilder.encode().build().toUri(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        List<CardResponse> cardList = new ArrayList<>();
        cardList.add(responseEntity.getBody());
        return cardList;
    }

    public List<CardResponse> getCardByMultiverse(CardRequest cardRequest) {
        String url = scryfallUrl + "cards/multiverse/" + cardRequest.getMultiverseId();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                    uriComponentsBuilder.encode().build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ArrayList<>();
            } else {
                List<CardResponse> cardList = new ArrayList<>();
                cardList.add(responseEntity.getBody());
                return cardList;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ArrayList<>();
            } else {
                throw e;
            }
        } catch (HttpServerErrorException e) {
            throw e;
        }
    }

    public List<CardResponse> getCardByCatalog(CardRequest cardRequest) {
        String url = scryfallUrl + "cards/mtgo/" + cardRequest.getMtgoId();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                    uriComponentsBuilder.encode().build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ArrayList<>();
            } else {
                List<CardResponse> cardList = new ArrayList<>();
                cardList.add(responseEntity.getBody());
                return cardList;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ArrayList<>();
            } else {
                throw e;
            }
        } catch (HttpServerErrorException e) {
            throw e;
        }
    }

    public List<CardResponse> getCardByCardId(CardRequest cardRequest) {
        String url = scryfallUrl + "cards/" + cardRequest.getId();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            ResponseEntity<CardResponse> responseEntity = restTemplate.exchange(
                    uriComponentsBuilder.encode().build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ArrayList<>();
            } else {
                List<CardResponse> cardList = new ArrayList<>();
                cardList.add(responseEntity.getBody());
                return cardList;
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ArrayList<>();
            } else {
                throw e;
            }
        } catch (HttpServerErrorException e) {
            throw e;
        }
    }

    public Double getSetPrice(Long setId) {
        try {
            double totalPriceUSD = 0.0;
            Optional<Set> set = setRepository.findById(setId);
            List<Card> cards = set.get().getCards();

            CardRequest cardRequest = new CardRequest();
            for (Card card : cards) {
                String cardId = card.getId();
                cardRequest.setId(cardId);
                CardResponse cardResponse = getCardById(cardRequest);
                if (cardResponse != null && cardResponse.getPrices() != null) {
                    String usdPrice = cardResponse.getPrices().getUsd();
                    if (usdPrice != null && !usdPrice.isEmpty()) {
                        totalPriceUSD += Double.parseDouble(usdPrice);
                    }
                }
            }
            totalPriceUSD = totalPriceUSD * 100;
            totalPriceUSD = Math.round(totalPriceUSD);
            totalPriceUSD = totalPriceUSD / 100;
            return totalPriceUSD;
        } catch (Exception e) {
            throw new RuntimeException("Error calculating total price", e);
        }
    }
}
