package Classifier;

import java.util.HashMap;

public class NaiveBayesClassifier {
   
	private float prob_word_class_pos=1;
    private float prob_word_class_neg=1;
    private int count_pos=0;
    private int count_neg=0;
    
	public NaiveBayesClassifier(String query,HashMap<String,Integer> hmpos,HashMap<String,Integer> hmneg){
		
        for(HashMap.Entry<String, Integer> entry: hmpos.entrySet()) {
            count_pos+=entry.getValue();
        }
        
        
        for(HashMap.Entry<String, Integer> entry: hmneg.entrySet()) {
            count_neg+=entry.getValue();
        }
        
		String input_tokens[] = query.split(" ");
		for(int i=0;i<input_tokens.length;i++){
        	
        	if(hmpos.containsKey(input_tokens[i])){
        		prob_word_class_pos*=((float)(hmpos.get(input_tokens[i])+1)/(float)(hmpos.size()+hmneg.size()+count_pos));
        	}
        	else{
        		prob_word_class_pos*=((float)(1)/(float)(hmpos.size()+hmneg.size()+count_pos));
        	}
    	
        }
        
        for(int i=0;i<input_tokens.length;i++){
        	
        	if(hmneg.containsKey(input_tokens[i])){
        		prob_word_class_neg*=((float)(hmneg.get(input_tokens[i])+1)/(float)(hmneg.size()+hmneg.size()+count_neg));
        	}
        	else{
        		prob_word_class_neg*=((float)(1)/(float)(hmneg.size()+hmneg.size()+count_neg));
        	}      	
        }
	}

	public float getProb_word_class_pos() {
		return prob_word_class_pos;
	}


	public float getProb_word_class_neg() {
		return prob_word_class_neg;
	}	
	
}
