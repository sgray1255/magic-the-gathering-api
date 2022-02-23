package com.MTGAPI.magic.card;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private static final ModelMapper mapper = new ModelMapper();

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List <Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card find(Long id) {
        Optional<Card> card = this.cardRepository.findById(id);
        if(card.isEmpty()) {
            throw new Error(String.format("Card with id:%d cannot be found.", id));
        }
        return card.get();
    }

    public List <Card> findByQuery(String query ){

        return this.cardRepository.getQueryMatch(query);
    }


    public Card createNewCard(CardCreatePayload data) {
        Card newCard = new Card();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.map(data, newCard);
        this.cardRepository.save(newCard);
        return newCard;
    }

    public Card updateCard(Long id, CardUpdatePayload data) {
        var card = this.find(id);
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
            mapper.map(data, card);
           this.cardRepository.save(card);
           return card;
    }

     public void delete(Long id) {
        this.cardRepository.deleteById(id);
    }


}
