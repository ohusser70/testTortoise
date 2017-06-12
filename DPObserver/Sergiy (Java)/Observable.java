
package ch.hearc.genielog;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Observable implements Observable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Observable(JPanel jPanel)
		{
		this.jPanel = jPanel;
		listeObserveurs = new ArrayList<Observateur_I>();
		Thread t = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				while(true)
					{
					System.out.println();//sinon ca marche pas, on aurait bien pu sacrifier une vierge aussi ou faire une prière à C'Thulhu
					if (Observable.this.jPanel.getSize().getWidth() > 500 && Observable.this.jPanel.getSize().getHeight() > 500)
						{
						Observable.this.notifierObservateurs();
						}
					}
				}
			});
		t.start();

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void ajouterObservateur(Observateur_I observateur)
		{
		listeObserveurs.add(observateur);

		}

	@Override
	public void supprimerObservateur(Observateur_I observateur)
		{
		listeObserveurs.remove(observateur);

		}

	@Override
	public void notifierObservateurs()
		{
		for(Observateur_I observateur_I:listeObserveurs)
			{
			observateur_I.notification();
			}

		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private List<Observateur_I> listeObserveurs;
	private JPanel jPanel;
	}
