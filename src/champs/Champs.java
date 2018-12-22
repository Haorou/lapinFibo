package champs;

import java.util.ArrayList;
import java.util.List;

import animaux.CoupleAnimaux;
import animaux.CoupleCochons;
import animaux.CoupleLapins;
import animaux.ICoupleAnimaux;

public abstract class Champs implements IChamps<ICoupleAnimaux>
{	
	protected int mois = 0;
	protected List<ICoupleAnimaux> listeDeCouples = new ArrayList<ICoupleAnimaux>();

	public void add(ICoupleAnimaux coupleAnimaux)
	{
		this.listeDeCouples.add(coupleAnimaux);
	}
	
	public ICoupleAnimaux get(int x)
	{
		return this.listeDeCouples.get(x);
	}
	
	public void reinitialiserListe()
	{
		this.listeDeCouples = new ArrayList<ICoupleAnimaux>();
	}
	
	public void vieillir()
	{
		for (ICoupleAnimaux coupleAnimaux : listeDeCouples) 
			coupleAnimaux.vieillir();
		
		for (int indexAnimal = 0; indexAnimal < listeDeCouples.size() ;indexAnimal++) 
		{
			if(get(indexAnimal).getEstAdulte() && !get(indexAnimal).estEnGestation())
			{
				add(get(indexAnimal).procreer());			
			}
		}
		this.mois++;
	}
	
	public void afficherStats()
	{
		System.out.println(this.mois + " mois sont passés");
		System.out.println("-----------------------------");
		for (ICoupleAnimaux coupleAnimaux : listeDeCouples) 
		{
			coupleAnimaux.statistiqueNaissance();
		}
		System.out.println("-----------------------------");
	}
	
	public static void statsGlobal()
	{
		System.out.println("Au total on comtpe : " + CoupleAnimaux.compteurGeneral + " animaux");
		System.out.println("Il y a " + CoupleLapins.nombreAnimauxDeCetteEspeceAuTotal + " animaux de l'espéce : " + CoupleLapins.ESPECE );
		System.out.println("Il y a " + CoupleCochons.nombreAnimauxDeCetteEspeceAuTotal + " animaux de l'espéce : " + CoupleCochons.ESPECE );
	}
}
