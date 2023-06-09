package com.javaminiproject.model;

public class Quiz {

private Integer id;
	
	private String question;
	
	private String opt1;
	
	private String opt2;
	
	private String opt3;
	
	private String opt4;
	
	private String correct;

	

	
	//generating getter and setters
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
	//generrate tostring including methods
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
				+ ", opt4=" + opt4 + ", correct=" + correct + ", getId()=" + getId() + ", getQuestion()="
				+ getQuestion() + ", getOpt1()=" + getOpt1() + ", getOpt2()=" + getOpt2() + ", getOpt3()=" + getOpt3()
				+ ", getOpt4()=" + getOpt4() + ", getCorrect()=" + getCorrect() + "]";
	}

	
}
