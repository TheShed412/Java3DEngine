public class NotInitializedException extends Exception
{
    @SuppressWarnings("serial")
  public NotInitializedException(){ super(); }
  public NotInitializedException(String mess){ super(mess); }
  public NotInitializedException(String mess, Throwable cause){ super(mess, cause); }
  public NotInitializedException(Throwable cause){ super(cause); }
}
