package animaux;

import java.util.ArrayList;
import java.util.List;

public abstract class CoupleAnimaux implements ICoupleAnimaux 
{
	public static int compteurGeneral = 0;
	protected int nombreAnimauxDeCetteEspaceAMaNaissance=0;
	
	private int age = -getTempsDeGestation();
	private int tempsGestation = 0;
	
	private boolean estEnGestation = false;
	private boolean estBebe = true;
	private boolean estNe = false;
	private boolean estAdulte = false;

	protected List<CoupleAnimaux> enfants = new ArrayList<CoupleAnimaux>();
	
	public CoupleAnimaux()
	{
		addNombreAnimauxDeCetteEspeceAuTotal();
		setNombreAnimauxdeCetteEspeceAMaNaissance(getNombreAnimauxDeCetteEspeceAuTotal());
		compteurGeneral++;
	}

	public int getTempsGestation() 							{	return tempsGestation;					}
	public void setTempsGestation(int temps) 				{	this.tempsGestation = temps;			}
	public void tempsGestationPlusUn()						{	this.tempsGestation++;					}
	
	public boolean estEnGestation() 						{	return estEnGestation;					}
	protected void setEstEnGestation(boolean estEnGestation){	this.estEnGestation = estEnGestation;	}
	
	private boolean getEstNe()  							{   return estNe;   						}
	protected void setEstNe(boolean estNe)     			    {   this.estNe = estNe;            			}
	
	private boolean getEstBebe()    						{   return estBebe;         				}
	protected void setEstBebe(boolean estBebe)              {   this.estBebe = estBebe;                 }
	
	public boolean getEstAdulte()  							{   return estAdulte;   					}	
	protected void setEstAdulte(boolean estAdulte)          {   this.estAdulte = estAdulte;             }
	
	private int getNbEnfants()								{	return this.enfants.size();				}
	
	public int getAge() 									{	return age;								}
	public void setAge(int age)								{	this.age = age;							}
	public void agePlusUn() 								{	this.age++; 							}

	public void vieillir()
	{	
		agePlusUn();
		
		if(this.getEstBebe())
			seDeveloppe();		
		else if(this.getEstNe())
			croitre();
		
		if(this.getEstAdulte() && this.estEnGestation())
			gestation();
	}
	
	public void seDeveloppe() {
		if(this.getAge() == 0)
		{
			this.estBebe = false;
			this.estNe = true;
		}
	}
	
	public void croitre() {
		if(this.getAge() == this.getTempsPassageAgeAdulte())
			this.estAdulte = true;

	}
	
	private void gestation() {
		this.tempsGestationPlusUn();
		if(this.getTempsGestation() == this.getTempsDeGestation())
		{
			this.setEstEnGestation(false);
			this.setTempsGestation(0);
		}
	}
	
	public void statistiqueNaissance()
	{
		if(this.getAge()>0)
		{
			if(this.getAge() > this.getTempsPassageAgeAdulte())
			{
				System.out.println("Le couple de "+ this.getEspece() +"s n° " + getNombreAnimauxDeCetteEspaceAMaNaissance() +" à " + this.getAge() +" mois et à " +getNbEnfants() + " enfants");
			}
			else if(this.getAge() == this.getTempsPassageAgeAdulte())
			{
				System.out.println("Le couple de "+ this.getEspece() +"s n° " + getNombreAnimauxDeCetteEspaceAMaNaissance() +" à " + this.getAge() +" mois et il est devenu adulte");
			}
			else
			{
				System.out.println("Le couple de "+ this.getEspece() +"s n° " +getNombreAnimauxDeCetteEspaceAMaNaissance() + " à " + this.getAge() + " mois et n'est pas en age de procréer");
			}

		}
		else if(this.getAge() == 0)
		{
			System.out.println("Le couple de "+ this.getEspece() +"s n° " +getNombreAnimauxDeCetteEspaceAMaNaissance() + " vient de naitre");
		}
		else
		{
			System.out.println("Le couple de "+ this.getEspece() +"s n° " +getNombreAnimauxDeCetteEspaceAMaNaissance() + " est en gestation pour " + Math.abs(this.getAge()) + " mois");			
		}



	}
	@Override
	public String toString() {
		return "CoupleAnimaux [nombreAnimauxDeCetteEspaceAMaNaissance=" + nombreAnimauxDeCetteEspaceAMaNaissance
				+ ", age=" + age + ", tempsGestation=" + tempsGestation + ", estEnGestation=" + estEnGestation
				+ ", estBebe=" + estBebe + ", estNe=" + estNe + ", estAdulte=" + estAdulte + ", enfants= \n" + enfants
				+ ", estEnGestation()=" + estEnGestation() + ", getEstNe()=" + getEstNe() + ", getEstBebe()="
				+ getEstBebe() + ", getNbEnfants()=" + getNbEnfants() + "]";
	}
}
