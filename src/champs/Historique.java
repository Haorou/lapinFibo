package champs;

import java.util.ArrayList;
import java.util.List;

import animaux.CoupleCochons;
import animaux.CoupleLapins;

public class Historique
{
	
	List<ChampsGenerique> listeDeChamps = new ArrayList<ChampsGenerique>();
	ChampsGenerique premierChamps;

	public Historique()	{}
	
	public Historique(ChampsGenerique nouveauChamps)
	{
		this.premierChamps = nouveauChamps;
	}
	
	public boolean add(ChampsGenerique champs)
	{
		return this.listeDeChamps.add(champs);
	}
	
	public void vieillirDe(int etapes)
	{
		for (int i = 0; i < etapes; i++) 
		{
			add(premierChamps.clone());
			premierChamps.vieillir();
		}
	}
	
	public void statsDesChamps()
	{
		for (ChampsGenerique iChamps : listeDeChamps) 
		{
			iChamps.afficherStats();
			System.out.println("---------------------------------------------------------");
		}
		Champs.statsGlobal();
	}
	
	public void statsDuChamps(int index)
	{
		for (int i = 0; i <= index; i++) 
		{
			premierChamps.vieillir();
			add(premierChamps.clone());
		}
		listeDeChamps.get(index).afficherStats();;
		Champs.statsGlobal();
	}
	
	public static void main (String[] args)
	{
		Historique histo = new Historique(new ChampsGenerique());
		histo.premierChamps.add(CoupleLapins.premierCouple());
		histo.premierChamps.add(CoupleCochons.premierCouple());
		histo.statsDuChamps(10);
	}
}
