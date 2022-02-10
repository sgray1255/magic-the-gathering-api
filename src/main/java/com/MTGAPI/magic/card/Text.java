package com.MTGAPI.magic.card;

import java.util.ArrayList;

public class Text {
    private Long id;
    private String abilities;
    private String flavorText;

    public Text() {
    }

    public Text(Long id, String abilities, String flavorText) {
        this.id = id;
        this.abilities = abilities;
        this.flavorText = flavorText;
    }

    public Text(String abilities, String flavorText) {
        this.abilities = abilities;
        this.flavorText = flavorText;
    }
}
