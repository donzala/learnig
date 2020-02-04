package fr.epita.quiz.services.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import fr.epita.quiz.datamodel.McqQuestion;

public class McqQuestionsDAO {
	
	
	private static final String TOPIC_DELIMITER = "|";
	private static final String DELIMITER = ";";
	//for writing a file
	private File file = new File("/Users/prashanth/Mylio/sample.csv");
	private PrintWriter writer;
	
	public McqQuestionsDAO() throws FileNotFoundException {
		this.writer = new PrintWriter(new FileOutputStream(this.file, true));
	}
	
	public void create(McqQuestion question) {
		String formatted = String.valueOf(question.getId()) + DELIMITER;
		formatted += question.getQuestion() + DELIMITER;
		formatted += question.getDifficulty() + DELIMITER;
		
		String[] topics = question.getTopics();
		for (int i = 0; i < topics.length; i++) {
			formatted += topics[i] + TOPIC_DELIMITER;
		}
	
		//TODO complete by appending the formatted line in file
		this.writer.println(formatted);
		this.writer.flush();
		this.writer.close();
	
	
	}
	//write
	
	public void write(ArrayList<McqQuestion> l) throws Exception {
		PrintWriter writer1=new PrintWriter(new FileOutputStream(this.file, true));
		for(int i=0;i<l.size();i++) {
			String formatted = String.valueOf(l.get(i).getId()) + DELIMITER;
			formatted += l.get(i).getQuestion() + DELIMITER;
			formatted += l.get(i).getDifficulty() + DELIMITER;
			
			String[] topics = l.get(i).getTopics();
			for (int j = 0; j < topics.length; j++) {
				formatted += topics[j] + TOPIC_DELIMITER;
			}
		
			//TODO complete by appending the formatted line in file
			writer1.println(formatted);
			writer1.flush();
		}
			writer1.close();
		
		
	
	
	}
	
	public List<McqQuestion> readAll() {
		
		List<McqQuestion> results = new ArrayList<>();
		//TODO complete by reading all the lines from a file
		String str="";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			 
			while ((str = br.readLine()) != null) { 
				//while there is something to read in the file;
				System.out.println(str);
				if(str!="") {
					
					String formatted = str; //TODO this is the current read line
					String[] parts = formatted.split(DELIMITER);
					Long id = Long.valueOf(parts[0]);
					String readQuestion = parts[1];
					Integer difficulty = Integer.valueOf(parts[2]);
					String rawTopics = parts[3];
					String[] subparts = rawTopics.split("\\" +TOPIC_DELIMITER);
					
					McqQuestion readInstance = new McqQuestion();
					readInstance.setId(id);
					readInstance.setQuestion(readQuestion);
					readInstance.setDifficulty(difficulty);
					readInstance.setTopics(subparts);
				
					results.add(readInstance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		
			
		
		return results;
		
	}
	
	public McqQuestion getById(List<McqQuestion> qBank,long id) {
		//TODO complete
		McqQuestion mcqID= new McqQuestion();
		for(int i=0;i<qBank.size();i++) {
			if(id==qBank.get(i).getId()) 
				mcqID=qBank.get(i);
		}
		String formatted = String.valueOf(mcqID.getId()) + DELIMITER;
		formatted += mcqID.getQuestion() + DELIMITER;
		formatted += mcqID.getDifficulty() + DELIMITER;
		
		String[] topics = mcqID.getTopics();
		for (int i = 0; i < topics.length; i++) {
			formatted += topics[i] + TOPIC_DELIMITER;
		}
		String[] mcqRead=formatted.split(DELIMITER);
		System.out.println(Arrays.asList(mcqRead));
		
		return mcqID;
	}
	

}
