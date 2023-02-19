import java.io.IOException;
import java.net.SocketException;
import java.nio.file.AccessDeniedException;
import java.rmi.server.ExportException;

class ExceptionHandlingExample {

    public void raiseException(int num) throws IOException, ClassNotFoundException, AccessDeniedException, ExportException, IllegalArgumentException, SocketException {
        switch (num) {
            case 1:
                throw new SocketException();
            case 2:
                throw new ClassNotFoundException();
            case 3:
                throw new AccessDeniedException("Access denied");
            case 4:
                throw new ExportException("Export exception");
            default:
                throw new IllegalArgumentException("Invalid argument");
        }
    }

    public String catchException(int num) {
        try {
            raiseException(num);
        } catch (SocketException e) {
            return "SocketException";
        } catch (ClassNotFoundException e) {
            return "ClassNotFoundException";
        } catch (AccessDeniedException e) {
            return "AccessDeniedException";
        } catch (ExportException e) {
            return "ExportException";
        } catch (IllegalArgumentException e) {
            return "IllegalArgumentException";
        } catch (IOException e) {
            return "IOException";
        } catch (Exception e) {
            return "Exception";
        }
        return null;
    }

}

public class ch2Dz3 {
    public static void main(String[] args) {
        ExceptionHandlingExample example = new ExceptionHandlingExample();

        for (int i = 1; i <= 4; i++) {
            String exceptionName = example.catchException(i);
            System.out.println("Exception for num = " + i + ": " + exceptionName);
        }
    }
}
