package com.MTGAPI.magic.card;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        return this.cardService.find(id);
    }

    @PostMapping
    public void createNewCard(@RequestBody CardCreatePayload data) {
        Card card = this.cardService.createNewCard(data);
    }

    @PatchMapping(value = "/{id}")
    public Card update(@PathVariable Long id, @RequestBody CardUpdatePayload data) throws JsonProcessingException {
        return this.cardService.updateCard(id, data);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        this.cardService.delete(id);
    }


}
