package co.project.exception;

public class ErreurDeraillement extends Exception{

	/**
	 * @param string
	 * d�passement de but�e
	 */
	public ErreurDeraillement(String string) {
		super(string);
	}

}
