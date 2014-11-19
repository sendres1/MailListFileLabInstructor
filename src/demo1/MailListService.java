package demo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author jlombardo
 */
public class MailListService {
    private MailListOutputStrategy output;
    
    public void produceMailListFromFile(String filePath, MailListOutputStrategy strategy) {
        if(strategy == null) throw new IllegalArgumentException("a MailListOutputStrategy is required.");
        
        output = strategy;
        List<String> list = new ArrayList<>();
        
        try {
            list = readFileLines(filePath);
            output.outputData(list);
            
        } catch (IOException ex) {

            list.add(ex.getMessage());
            output.outputData(list);
        }
    }
    
    public List<Map<String,String>> readFile(String filePath) throws IOException {
        List<Map<String,String>> records = new ArrayList<>();
        
        List<String> lines = readFileLines(filePath);
        
        for(String line : lines) {
            String[] parts = line.split(" ");
            Map<String,String> rec = new LinkedHashMap<>();
            for(int i=0; i < parts.length; i++) {
                // decided to use a 1-based numbering system
                rec.put("" + (i+1), parts[i]);
            }
            records.add(rec);
        }
        
        return records;
    }
    
    private List<String> readFileLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));
	   String line = in.readLine();
	   while(line != null){
		  lines.add(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
        
        return lines;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.output);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MailListService other = (MailListService) obj;
        if (!Objects.equals(this.output, other.output)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MailListService{" + output.toString() + '}';
    }
    
    
}
