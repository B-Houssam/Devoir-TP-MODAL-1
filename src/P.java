import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;

public class P {

	public P() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			showMessageDialog(null, "Le programme suivant va créer des instance d'Etudiant a partir d'un fichier text\nConsulter la console pour voir la progression");
			
			String currentLine = null;
			
			//trigger Exception
			//int i = 14/0;
			
			Scanner choice = new Scanner(System.in);
			Boolean ok = true;
			
			
			while (ok) {
			      System.out.print("1- afficher les objets récupérées\n2- sauvgarder dans un fichier binnaire ces objets\n0- quitter\n");
			      int k = choice.nextInt();
			      switch (k) {
				case 1:
					File f = new File ("/home/houssam/workspace/projects/Java/Logs/F.txt");
					BufferedReader br = new BufferedReader(new FileReader(f));
					while ((currentLine = br.readLine()) != null) 
				    {
						String[] data = currentLine.split(" ");
						Etudiant e = new Etudiant(data[1],data[0],data[3],data[4],data[2]);
						e.read();
				    }
					br.close();
					break;
				case 2:
					File ff = new File ("/home/houssam/workspace/projects/Java/Logs/F.txt");
					BufferedReader brr = new BufferedReader(new FileReader(ff));
					while ((currentLine = brr.readLine()) != null) 
				    {
						String[] data = currentLine.split(" ");
						Etudiant e = new Etudiant(data[1],data[0],data[3],data[4],data[2]);
						e.save();
				    }
					brr.close();
					Etudiant tt = new Etudiant();
					tt.readFile();
					break;
				case 0: 
					ok = false;
					break;
				default:
					break;
				}	
			}
			
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
