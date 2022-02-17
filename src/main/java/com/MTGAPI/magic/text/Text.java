package com.MTGAPI.magic.text;

import com.MTGAPI.magic.card.Card;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "card_text")
public class Text implements Serializable {

    @Id
    @Column(name = "text_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "text_id")
    private Card card;

    private String abilities;
    private String flavorText;

    public Text() {
    }


    public Text(Card card, String abilities, String flavorText) {
        this.card = card;
        this.abilities = abilities;
        this.flavorText = flavorText;
    }
}
