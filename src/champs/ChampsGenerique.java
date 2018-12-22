package champs;

import animaux.ICoupleAnimaux;

public class ChampsGenerique extends Champs
{	
	public ChampsGenerique() {}
	
	public ChampsGenerique(ICoupleAnimaux iCoupleAnimaux) {
		this.add(iCoupleAnimaux);
	}
	
	public ChampsGenerique clone() {
		ChampsGenerique cloneChamps = null;

		try 
		{
			cloneChamps = (ChampsGenerique) super.clone();
			cloneChamps.reinitialiserListe();
			
			for (ICoupleAnimaux coupleAnimaux : listeDeCouples) 
			{
				cloneChamps.add(coupleAnimaux.cloneGenerique());
			}
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	
		return cloneChamps;
	}

}
