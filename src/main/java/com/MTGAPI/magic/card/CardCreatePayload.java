package com.MTGAPI.magic.card;

import com.sun.istack.NotNull;

public class CardCreatePayload {

    @NotNull
    private String name;

    @NotNull
    private Integer cmc;

    //    Mana Type Reference:
//    W = White =  (Comes from Plains basic land)
//    U = Blue =  = (Comes from Island basic land)
//    B = Black =  = (Comes from Swamp basic land)
//    R = Red =  = (Comes from Mountain basic land)
//    G = Green -  = (Comes from Forest basic land)
    @NotNull
    private String mana_type;

    @NotNull
    private String type_line;

    @NotNull
    private String expansion;

    @NotNull
    private Integer power;

    @NotNull
    private Integer toughness;

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

    public CardCreatePayload() {};

    public CardCreatePayload(
            String name,
            Integer cmc,
            String mana_type,
            String type_line,
            String expansion,
            Integer power,
            Integer toughness
    ) {
        this.setName(name);
        this.setCmc(cmc);
        this.setMana_type(mana_type);
        this.setType_line(type_line);
        this.setExpansion(expansion);
        this.setPower(power);
        this.setToughness(toughness);
    }
}
