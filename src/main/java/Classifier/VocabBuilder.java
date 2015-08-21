package Classifier;

import java.io.IOException;
import java.util.HashMap;

public class VocabBuilder {

	private HashMap<String,Integer> hmpos = new HashMap<String,Integer>();
	private HashMap<String,Integer> hmneg = new HashMap<String,Integer>();
	private int pos = 0;
    private int neg = 0;
	
	public VocabBuilder() {
		super();
	}
	public VocabBuilder(String fileName) throws IOException{
		
		String line;
        LineReader lineReader = new LineReader(fileName);
        
        
        
        while ((line = lineReader.nextLine()) != null) {
	            
            String lineTrimmed = line.trim();
            if (lineTrimmed.isEmpty()) continue;
            String[] queryTokens = lineTrimmed.split(":");
            String classify = queryTokens[0].trim();           
            String rest = queryTokens[1].trim();
            String[] queryTokens1 =rest.split(" ");
            
            if(classify.equals("positive")){
            	pos++;
            
	            for(int i=0;i<queryTokens1.length;i++){
	            	if(hmpos.containsKey(queryTokens1[i].toLowerCase())){	            		
	            		hmpos.put(queryTokens1[i].toLowerCase(),hmpos.get(queryTokens1[i].toLowerCase())+1);
	            	}
	            	else{
	            		hmpos.put(queryTokens1[i].toLowerCase(), 1);
	            	}
	            }
            }            
            else {
            	
            	neg++;
            	for(int i=0;i<queryTokens1.length;i++){
	            	if(hmneg.containsKey(queryTokens1[i].toLowerCase())){
	            		hmneg.put(queryTokens1[i].toLowerCase(),hmneg.get(queryTokens1[i].toLowerCase())+1);	            		
	            	}
	            	else{
	            		hmneg.put(queryTokens1[i].toLowerCase(), 1);
	            	}
	            }
            }
            
        }
	}
	
	
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getNeg() {
		return neg;
	}
	public void setNeg(int neg) {
		this.neg = neg;
	}
	public HashMap<String, Integer> getHmpos() {
		return hmpos;
	}
	public void setHmpos(HashMap<String, Integer> hmpos) {
		this.hmpos = hmpos;
	}
	public HashMap<String, Integer> getHmneg() {
		return hmneg;
	}
	public void setHmneg(HashMap<String, Integer> hmneg) {
		this.hmneg = hmneg;
	}
	 
	 
}
