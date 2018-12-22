package animaux;

public interface ICoupleAnimaux extends Cloneable
{	
	public String getEspece();
	public int getTempsDeGestation();
	public int getTempsPassageAgeAdulte();
	
	public boolean estEnGestation();
	public boolean getEstAdulte();

	public int getNombreAnimauxDeCetteEspaceAMaNaissance();
	public void setNombreAnimauxdeCetteEspeceAMaNaissance(int nbr);

	public int getNombreAnimauxDeCetteEspeceAuTotal();
	public void addNombreAnimauxDeCetteEspeceAuTotal();
	
	public void vieillir();
	
	public ICoupleAnimaux procreer();
	public ICoupleAnimaux cloneGenerique();
	
	public void statistiqueNaissance();
}
