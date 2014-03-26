package demo;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class number {
	public int usernumber;
	private int randomnumber;

	public number() {
		randomnumber = new Double(Math.random() * 100).intValue();
	}

	public int getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(int usernumber) {
		this.usernumber = usernumber;
	}

	public int getRandomnumber() {
		return randomnumber;
	}

	public void setRandomnumber(int randomnumber) {
		this.randomnumber = randomnumber;
	}

	public String soumettre() {

		FacesContext context = FacesContext.getCurrentInstance();

		System.out.println("random" + randomnumber);
		if (usernumber < randomnumber) {

			context.addMessage(null, new FacesMessage(
					"Essayez un nombre plus grand"));
		}

		if (usernumber > randomnumber) {

			context.addMessage(null, new FacesMessage(
					"Essayez un nombre plus petit"));

		}

		if (usernumber == randomnumber) {

			return "success";
		}

		return "";
	}

	public String playagain() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		session.invalidate();
		return "invite";

	}
}
