package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.service.SurveyService;
import com.in28minutes.springboot.model.Question;;


@RestController
public class SurveyController {
	@Autowired
	private SurveyService surveyService;

	@GetMapping("/surveys/{surveyID}/questions")
	public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyID)
	{
		return surveyService.retrieveQuestions(surveyID);
	}
	
	
	
	@PostMapping("/surveys/{surveyID}/questions")
	public ResponseEntity<Void> addQuestionsToSurvey(@PathVariable String surveyID,@RequestBody Question newQuestion)
	{
		
		Question question = surveyService.addQuestion(surveyID, newQuestion);
		
		if(question==null)
			return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(question.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/surveys/{surveyID}/questions/{questionID}")
	public Question retrieveDetailForQuestion(@PathVariable String surveyID, @PathVariable String questionID)
	{
		return surveyService.retrieveQuestion(surveyID, questionID);
	}
}
