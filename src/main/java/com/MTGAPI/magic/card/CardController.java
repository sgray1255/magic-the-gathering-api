package com.MTGAPI.magic.card;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return this.cardService.getAllCards();
    }

    @GetMapping(value="/{id}")
    public Card findCard (@PathVariable Long id) {
        Optional<Card> card = Optional.ofNullable(cardService.find(id));

        if(card.isPresent()) {
            return card.get();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<String> createNewCard(@RequestBody CardCreatePayload data) {
        Card card = this.cardService.createNewCard(data);
        return new ResponseEntity<>("New card has been added.", HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public Card update(@PathVariable Long id, @RequestBody CardUpdatePayload data) throws JsonProcessingException {
        return this.cardService.updateCard(id, data);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.cardService.delete(id);
        return new ResponseEntity<>("Card has been successfully deleted.", HttpStatus.OK);
    }


}
