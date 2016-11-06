import java.util.List;

import metier.Classe;
import session.ClasseDAO;

public class Test {

	public static void main(String[] args) {

		ClasseDAO metier = new ClasseDAO();

		List<Classe> activities = metier.getAllClasse();

		for (Classe a : activities) {
			System.out.println(a.getNomClasse());
			System.out.println(a.getIdfiliere());
		}
		System.out.println(metier.getClasseById(2).getNomClasse());
}

}
