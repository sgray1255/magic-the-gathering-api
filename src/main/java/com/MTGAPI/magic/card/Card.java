package com.MTGAPI.magic.card;

public class Card {
    private Long id;
    private String name;
    private Integer cmc;
    private String mana_type;
    private String type_line;
    private String expansion;
    private Integer power;
    private Integer toughness;

    public Card() {
    }

    public Card(Long id, String name, Integer cmc, String mana_type, String type_line, String expansion, Integer power, Integer toughness) {
        this.id = id;
        this.name = name;
        this.cmc = cmc;
        this.mana_type = mana_type;
        this.type_line = type_line;
        this.expansion = expansion;
        this.power = power;
        this.toughness = toughness;
    }

    public Card(String name, Integer cmc, String mana_type, String type_line, String expansion, Integer power, Integer toughness) {
        this.name = name;
        this.cmc = cmc;
        this.mana_type = mana_type;
        this.type_line = type_line;
        this.expansion = expansion;
        this.power = power;
        this.toughness = toughness;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCmc() {
        return cmc;
    }

    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }

    public String getMana_type() {
        return mana_type;
    }

    public void setMana_type(String mana_type) {
        this.mana_type = mana_type;
    }

    public String getType_line() {
        return type_line;
    }

    public void setType_line(String type_line) {
        this.type_line = type_line;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getToughness() {
        return toughness;
    }

    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cmc=" + cmc +
                ", mana_type='" + mana_type + '\'' +
                ", type_line='" + type_line + '\'' +
                ", expansion='" + expansion + '\'' +
                ", power=" + power +
                ", toughness=" + toughness +
                '}';
    }
}