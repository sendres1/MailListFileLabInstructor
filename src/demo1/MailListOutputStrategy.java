package demo1;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jlombardo
 */
public interface MailListOutputStrategy {

    public abstract void outputData(List<String> lines);
    
    public abstract String getName();
}
