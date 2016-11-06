package interfaceentity;

import java.util.List;

import metier.Commentaire;

public interface InterfaceComentaire {

	 public void setcommentaire(Commentaire c);
	 public List<Commentaire> getAllcommentaire();
	 public Commentaire getcommentaireById(int id);
	 public void updatecommentaire(Commentaire u);
	 public void delatecommentaire(Commentaire u);
}
