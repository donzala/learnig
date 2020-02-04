package fr.epita.quiz.tester;

import java.util.List;

import fr.epita.quiz.datamodel.McqQuestion;
import fr.epita.quiz.services.data.McqQuestionsDAO;

public class TestCode {
	public static void main(String[] args) {
			
			McqQuestion question = new McqQuestion();
			question.setDifficulty(5);
			question.setTopics(new String[] {"java","uml","oop"});
			question.setQuestion("Define inheritance  in java?");
			question.setId(1);
			try {
				
				McqQuestionsDAO mcq=new McqQuestionsDAO();
				mcq.create(question);
				List<McqQuestion> questionBank=mcq.readAll();
				McqQuestion getQuestion= mcq.getById(questionBank,2);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
