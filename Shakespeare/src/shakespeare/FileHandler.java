/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

/**
 *
 * @author TimmosQuadros
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class FileHandler {

	//Tester
//	public static void main(String[] args) {
//		FileHandler fh = new FileHandler();
//
//		fh.loadTextFromFile("C:/temp/test.txt");
//	}

	public ArrayList<String> loadTextFromFile(String filename)
	{
		ArrayList<String> words = new ArrayList<>();
		String NewLine;

		FileReader TheFileReader;
		BufferedReader TheBufferedReader;

		try {
			TheFileReader = new FileReader(new File(filename));
			TheBufferedReader = new BufferedReader(TheFileReader);

			while((NewLine = TheBufferedReader.readLine()) != null){
				String[] cleanLine = NewLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" "); //removes all non characters
				for (String word : cleanLine) {
					if(!word.equalsIgnoreCase("")){
						//System.out.print(string+" ");
						words.add(word);
					}
				}
			}

			TheBufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}
	
	public void saveTextToFile(ArrayList<String> wordList, String filename)
    {       
        try
        {
            FileWriter TheFileWriter = new FileWriter(new File(filename));
            
            for(int i = 0; i < wordList.size(); i++)
            {
                TheFileWriter.write(wordList.get(i) + " ");
            }           
            
            TheFileWriter.close();  
        }
        catch (IOException ex)
        {
            System.out.println("Could not write to file!");
            System.out.println(ex.toString());
        }
    }

}

