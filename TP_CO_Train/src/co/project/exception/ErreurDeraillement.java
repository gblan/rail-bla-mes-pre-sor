package co.project.exception;

public class ErreurDeraillement extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * @param string
	 * d�passement de but�e
	 */
	public ErreurDeraillement(String string) {
		super(string);
	}

}
