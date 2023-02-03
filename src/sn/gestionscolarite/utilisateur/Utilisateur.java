package sn.gestionscolarite.utilisateur;

public class Utilisateur {
	protected int id;
	protected String login;
	protected String password ;
	private static int nbUtilisteur;

	public Utilisateur(int id,String login, String pwd) {
		this(login, pwd);
		this.id=id;
	}


	public Utilisateur(String login, String password, String confirmePassword) {
		this(login, confirmePassword);
	}

	public Utilisateur(String login, String pwd) {
		this.login = login;
		this.password = pwd;

		nbUtilisteur ++;
		setId(nbUtilisteur);;
	}

	public Utilisateur() {
		this("noname", "0");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password= password;
	}

	public static int getNbUtilisteur() {
		return nbUtilisteur;
	}	
}
