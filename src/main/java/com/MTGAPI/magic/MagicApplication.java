package com.MTGAPI.magic;

import com.MTGAPI.magic.card.Card;
import com.MTGAPI.magic.card.Text;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@SpringBootApplication
@RestController
public class MagicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicApplication.class, args);
	}

//	Text bloodfire_colossus_text = new Text("Sacrifice Bloodfire Colossus: Bloodfire Colossus deals 6 damage to each creature and each player."
//			,"It took all its strength to contain the fire within."
//	);

	@GetMapping
	public List<Card> displayCard() {
		return List.of(
				new Card (
				1L,
				"Bloodfire Colossus",
				8,
				"R",
				"Creature-Giant",
				"9",
				6,
				6
				));
	}
}
