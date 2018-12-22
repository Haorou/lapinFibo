package champs;

import animaux.ICoupleAnimaux;

public interface IChamps<T extends ICoupleAnimaux> extends Cloneable 
{
	public void vieillir();
	public void afficherStats();
	public void add(T couple);


}
