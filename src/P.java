import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P {

	public P() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File f = new File ("/home/houssam/workspace/projects/Java/Logs/F.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String currentLine = null;
			
			//trigger Exception
			//int i = 14/0;
			
			while ((currentLine = br.readLine()) != null) 
		    {
				String[] data = currentLine.split(" ");
				Etudiant e = new Etudiant(data[1],data[0],data[3],data[4],data[2]);
				//pour afficher l'etudiant lut
				e.read();
				//pour sauvgarder dans un fichier .ser
				e.save();
		    }
			
			//pour lire le fichier binnaire
			Etudiant t = new Etudiant();
			t.readFile();
			
			br.close();
		} catch (IOException ee) {
			System.out.println("Erreur I/O fichier des Logs/Results.ser: " + ee.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(ee);
		} catch (Exception e){
		  // TODO: handle error
			System.out.println("Erreur: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			//sauvgarder les exceptions en fichiers .txt
			s.save(e);
		}finally {
			System.out.println("\n\n->Job Done!");
		}
	}
}
