package demo1;

import java.io.File;

/**
 *
 * @author jlombardo
 */
public class Startup {
    public static void main(String[] args) {
        MailListService srv = new MailListService();
        srv.produceMailListFromFile(
                "src" + File.separatorChar + "mailList.txt",
                new PersonConsoleOutput()
                );
    }
}
