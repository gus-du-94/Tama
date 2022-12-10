package pokemon;

import java.util.ArrayList;
import java.util.Random;

import tamagotchi.Tamagotchi;
import utils.Utilitaires;

public class Pokemon {
	public static Tamagotchi pokemon(Tamagotchi tama, Integer nbrTours) {
		ArrayList<Tamagotchi> tamaList = new ArrayList<Tamagotchi>();
		Random random = new Random();
		Integer nbr = random.nextInt(10);
		Tamagotchi tamaComb = new Tamagotchi();
		for (Integer i = 1; i < 10; i++) {
			String str = new String("Tamagotchi ");
			str += i.toString();
			Tamagotchi tama1 = new Tamagotchi();
			tama1.setNom(str);
			tama1 = Utilitaires.randTama(tama1);
			tamaList.add(tama1);
		}
		int cpt = 1;
		for (Tamagotchi tamagot : tamaList) {
			if (cpt == nbr) {
				tamaComb = tamagot;
				break;
			} else {
				cpt++;
			}
		}
		tama.setForce((nbrTours / 10) - tama.getMalusForce());
		tamaComb.setForce((nbrTours / 10) - tamaComb.getMalusForce());
		boolean different = false;
		Integer result1 = 0;
		Integer result2 = 0;
		while (!different) {
			Integer comb = random.nextInt(10);
			result1 = tama.getForce() + comb;
			result2 = tamaComb.getForce() + comb;
			System.out.printf("\n");
			System.out.println("attaque de votre tamagotchi : " + result1);
			System.out.println("attaque du tamagotchi enemi : " + result2);
			if (result1 != result2) {
				different = true;
			}
		}
		try {
			Thread.sleep(5);
		} catch (Exception expn) {
		}
		if (result1 > result2) {
			tama.setNbVictoire(tama.getNbVictoire() + 1);
			Utilitaires.victoire();
		} else {
			tamaComb.setNbVictoire(tamaComb.getNbVictoire() + 1);
			Utilitaires.defaite();
		}
		return tama;
	}
}
