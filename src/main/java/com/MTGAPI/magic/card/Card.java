package com.MTGAPI.magic.card;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "cards")
@Table(name = "cards")

public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="cmc", nullable = false)
    private Integer cmc;
//    Mana Type Reference:
//    W = White =  (Comes from Plains basic land)
//    U = Blue =  = (Comes from Island basic land)
//    B = Black =  = (Comes from Swamp basic land)
//    R = Red =  = (Comes from Mountain basic land)
//    G = Green -  = (Comes from Forest basic land)
    @Column(name = "mana_type", nullable = false)
    private String mana_type;

    @Column(name = "type_line", nullable = false)
    private String type_line;

    @Column(name = "expansion", nullable = false)
    private String expansion;

    @Column(name = "power", nullable = false)
    private Integer power;

    @Column(name = "toughness", nullable = false)
    private Integer toughness;

//    @OneToOne
//    @JoinColumn(name = "text_id", referencedColumnName = "id")
//    private Text text;

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
//        this.text = text;
    }

    public Card(String name, Integer cmc, String mana_type, String type_line, String expansion, Integer power, Integer toughness) {
        this.name = name;
        this.cmc = cmc;
        this.mana_type = mana_type;
        this.type_line = type_line;
        this.expansion = expansion;
        this.power = power;
        this.toughness = toughness;
//        this.text = text;
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

//    public Text getText() {
//        return text;
//    }
//
//    public void setText(Text text) {
//        this.text = text;
//    }

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
                ", text=" + text +
                '}';
    }
}
