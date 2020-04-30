package com.one2manyjpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one2manyjpa.entity.Answer;
import com.one2manyjpa.exception.ResourceNotFoundException;
import com.one2manyjpa.repository.AnswerRepository;
import com.one2manyjpa.repository.QuestionRepository;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private QuestionRepository qRepo;

	@GetMapping(value = "/question/{qId}/answer")
	public Optional<Answer> getAllCommentsByQuestionId(@PathVariable Integer qId) {
		Optional<Answer> ans = aRepo.findById(qId);
		return ans;
	}

	@PostMapping(value = "/add/{qId}/answer")
	public Answer addQuestion(@PathVariable Integer qId, @RequestBody Answer answer) {
		return qRepo.findById(qId).map(question -> {
			answer.setQuestion(question);
			return aRepo.save(answer);
		}).orElseThrow(() -> new ResourceNotFoundException("Question Id" + qId + "not found  "));

	}

	@DeleteMapping(value = "/delete/{qid}")
	public void delete(@PathVariable Integer qid) {
		try {
			Answer ans = aRepo.findById(qid).orElseThrow(() -> new AnswerNotFoundException("Answer is not Found !!!"));
			aRepo.deleteById(ans.getId());
		} catch (AnswerNotFoundException e) {
			System.out.println(e.getMessage());

		}

	}
}
