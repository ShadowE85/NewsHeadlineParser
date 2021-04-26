package ProfessionalProgramming;

		// All imports needed
		// jsoup from http://jsoup.org
import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.Font;
import java.io.IOException;

/**
 * 
 * @author Shadow
 *
 */

@SuppressWarnings("serial")
public class Main extends JFrame{	


public static void main (String arg[]){

	   JLabel label = new JLabel();
   
	   // try/catch statement for jsoup parsing 
		try {
			
	  // the target website being used for this app		
			String url ="http://news.google.com.au";
			Document doc = Jsoup.connect(url).get();
	  
	  // Syntax selector for elements 	
			Elements links = doc.select("a");
			
	  //Jsoup code to reiterate through the titles of the links	
			String output = "<html>";
			for(Element link : links){
				output += link.text() + "<br/>";
			}
		        output += "</html>";
			
	  //Parsing the data from jsoup to a Jlabel to display in the GUI
			  label.setText(output);
	   	
		}catch (IOException ex) {
				ex.printStackTrace();
			}
   
		// Creating the frame and scroll pane for easier viewing
   JFrame frame = new JFrame("News Headlines");
   JScrollPane sp = new JScrollPane(label);
   
   		// Scrollbar Policy
   sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
   		//GUI Frame
   
   		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	    frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setContentPane(sp);

		label.setSize(600,600);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
	}	
}
    
