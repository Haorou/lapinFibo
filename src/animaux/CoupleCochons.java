package animaux;

public class CoupleCochons extends CoupleAnimaux
{
	private static final int PERIODE_GESTATION = 3;
	private static final int PASSAGE_AGE_ADULTE = 6;
	public static final String ESPECE = "cochon";	
	
	public static int nombreAnimauxDeCetteEspeceAuTotal=0;

	public CoupleCochons()	{	super();	}

	public int getNombreAnimauxDeCetteEspeceAuTotal() 				{	return nombreAnimauxDeCetteEspeceAuTotal;			}
	public void addNombreAnimauxDeCetteEspeceAuTotal() 				{	nombreAnimauxDeCetteEspeceAuTotal++;				}
	public int getNombreAnimauxDeCetteEspaceAMaNaissance()  		{	return nombreAnimauxDeCetteEspaceAMaNaissance;		}
	public void setNombreAnimauxdeCetteEspeceAMaNaissance(int nbr)	{	this.nombreAnimauxDeCetteEspaceAMaNaissance = nbr;	}
	
	public int getTempsDeGestation() 			{	return PERIODE_GESTATION;		}
	public int getTempsPassageAgeAdulte() 		{	return PASSAGE_AGE_ADULTE;		}
	public String getEspece() 					{	return ESPECE;					}
	
	public static ICoupleAnimaux premierCouple()
	{
		CoupleCochons premierCouple = new CoupleCochons();
		premierCouple.setAge(0);
		premierCouple.setEstBebe(false);
		premierCouple.setEstNe(true);
		return premierCouple;
	}
	
	public ICoupleAnimaux procreer()
	{
		CoupleCochons coupleEnfant = new CoupleCochons();
		this.enfants.add(coupleEnfant);
		this.setEstEnGestation(true);
		return coupleEnfant;
	}
	
	public ICoupleAnimaux cloneGenerique()
	{
		CoupleCochons cloneCochons = null;
		try {
			cloneCochons = (CoupleCochons) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloneCochons;
	}
	
	public CoupleCochons clone()
	{
		CoupleCochons cloneCochons = null;
		try {
			cloneCochons = (CoupleCochons) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloneCochons;
	}

}
