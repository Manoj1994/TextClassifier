package Classifier;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

	private static Scanner s;

	public static void main(String[] args) throws IOException {
		
		String workingDirectory = "documents";
        if (!workingDirectory.endsWith("/")) workingDirectory = workingDirectory+"/";
        String fileName = workingDirectory+"training.txt";
        
        System.out.println("Text Classifier");
        
        HashMap<String,Integer> hmpos = new HashMap<String, Integer>();
        HashMap<String,Integer> hmneg = new HashMap<String, Integer>();
        int pos=0;
        int neg=0;
        
        VocabBuilder vocabulary = new VocabBuilder(fileName);
        hmpos=vocabulary.getHmpos();
        hmneg=vocabulary.getHmneg();
        pos=vocabulary.getPos();
        neg=vocabulary.getNeg();
            
           
	    while(true){
	            	
		    s = new Scanner(System.in);            
		    String query = s.nextLine();             
		    float prob_pos = (float)(pos)/(float)(pos+neg);
		    float prob_neg = (float)(neg)/(float)(pos+neg);
		            
		    NaiveBayesClassifier classifier = new NaiveBayesClassifier(query, hmpos, hmneg);
		    float prob_word_class_pos = classifier.getProb_word_class_pos()*prob_pos;
		    float prob_word_class_neg = classifier.getProb_word_class_neg()*prob_neg;
		            
		    if(prob_word_class_pos > prob_word_class_neg){
		    	System.out.print("Postive ");
		    }
		    else{
		    	System.out.print("Negative ");
		    }
		            
		    System.out.println();
	           
	    }
	}

}
