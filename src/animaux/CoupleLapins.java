package animaux;

public class CoupleLapins extends CoupleAnimaux
{
	private static final int PERIODE_GESTATION = 1;
	private static final int PASSAGE_AGE_ADULTE = 3;
	public static final String ESPECE = "lapin";
	
	public static int nombreAnimauxDeCetteEspeceAuTotal = 0;

	public CoupleLapins()	{	super();	}
	
	public int getNombreAnimauxDeCetteEspeceAuTotal() 				{	return nombreAnimauxDeCetteEspeceAuTotal;			}
	public void addNombreAnimauxDeCetteEspeceAuTotal() 				{	nombreAnimauxDeCetteEspeceAuTotal++;				}
	public int getNombreAnimauxDeCetteEspaceAMaNaissance()  		{	return nombreAnimauxDeCetteEspaceAMaNaissance;		}
	public void setNombreAnimauxdeCetteEspeceAMaNaissance(int nbr)	{	this.nombreAnimauxDeCetteEspaceAMaNaissance = nbr;	}
	
	public int getTempsDeGestation() 			{	return PERIODE_GESTATION;		}
	public int getTempsPassageAgeAdulte() 		{	return PASSAGE_AGE_ADULTE;		}
	public String getEspece() 					{	return ESPECE;					}
	
	public static ICoupleAnimaux premierCouple()
	{
		CoupleLapins premierCouple = new CoupleLapins();
		premierCouple.setAge(0);
		premierCouple.setEstBebe(false);
		premierCouple.setEstNe(true);
		return premierCouple;
	}
	
	public ICoupleAnimaux procreer()
	{
		CoupleLapins coupleEnfant = new CoupleLapins();
		this.enfants.add(coupleEnfant);
		this.setEstEnGestation(true);
		return coupleEnfant;
	}
	
	public ICoupleAnimaux cloneGenerique()
	{
		CoupleLapins cloneLapins = null;
		try 
		{
			cloneLapins = (CoupleLapins) super.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		return cloneLapins;
	}
	
	public CoupleLapins clone()
	{
		CoupleLapins cloneLapins = null;
		try 
		{
			cloneLapins = (CoupleLapins) super.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		return cloneLapins;
	}
}
