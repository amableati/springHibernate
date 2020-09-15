package springHibernate.common;

public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super("Exception Occured");
	}

	public ApplicationException(String arg0) {
		super(arg0);
	}
	
	public ApplicationException(Exception e){
	   super(e); 
	}

}
