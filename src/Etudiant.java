import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Etudiant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mat;
	String nom;
	String prenom;
	String spec;
	String niv;

	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	public Etudiant(String nom, String prenom, String niv, String spec, String mat) {
		// TODO Auto-generated constructor stub
		this.mat = mat;
		this.niv = niv;
		this.nom = nom;
		this.prenom = prenom;
		this.spec = spec;
	}
	
	//pour lire les enregistrement lut
	public void read() {
		System.out.println("\nL'Etudiant lit est: \n"+ this.prenom+" "+this.nom+"\nMatricule: "+ this.mat +"\nNiveau: " +this.niv+"\nSpecialité: "+this.spec+"\n");
	}
	
	//pour savgarder les objets en fichier .ser
	public void save() {
		// TODO Auto-generated method stub
		try {
			File f = new File ("/home/houssam/workspace/projects/Java/Logs/Results.ser");
			FileOutputStream fs = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
			fs.close();
		} catch (IOException ee) {
			System.out.println("Erreur I/O fichier des Logs/Results.ser: " + ee.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(ee);
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Erreur: " + ex.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(ex);
		}
	}
	
	//pour afficher le fichier .ser
	public void readFile() {
		try {
			String path = "/home/houssam/workspace/projects/Java/Logs/Results.ser";
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Etudiant et = (Etudiant)ois.readObject();
			System.out.println("\n-> La désérialisation: ");
			System.out.println(et.nom);
			System.out.println(et.prenom);
			System.out.println(et.mat);
			System.out.println(et.niv);
			System.out.println(et.spec+"\n");
			ois.close();
		} catch (IOException IOe) {
			// TODO: handle exception
			System.out.println("->Erreur I/O fichier des Logs-reading .ser: " + IOe.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(IOe);
		} catch (Exception e) {
			System.out.println(e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		}
	}
	
}
