package com.MTGAPI.magic.card;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value = "/api/cards")
public class CardController {

    @Autowired
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Card> getAllCards() {
        return this.cardService.getAllCards();
    }

    @GetMapping(value = "/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Card> getCardByQuery(@RequestParam String query) {
        return this.cardService.findByQuery(query);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Card findCard(@PathVariable Long id) throws Exception {
        Optional<Card> card = Optional.ofNullable(cardService.find(id));

        if (card.isPresent()) {
            return card.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> createNewCard(@Valid @RequestBody CardCreatePayload data) {
        Card card = this.cardService.createNewCard(data);

        return new ResponseEntity<Card>(card, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> update(@PathVariable Long id, @Valid @RequestBody CardUpdatePayload data) throws JsonProcessingException {
        Card updatedCard = this.cardService.updateCard(id, data);
        return new ResponseEntity<Card>(updatedCard, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.cardService.delete(id);
        return new ResponseEntity<>("Card has been successfully deleted.", HttpStatus.OK);
    }


}
