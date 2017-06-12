
package ch.hearc.genielog;



public interface Observable_I
	{
	public void ajouterObservateur(Observateur_I observateur);
	public void supprimerObservateur(Observateur_I observateur);
	public void notifierObservateurs();
	}

