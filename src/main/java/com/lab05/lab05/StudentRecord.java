package com.lab05.lab05;

public class StudentRecord {
    // initializing local variables
    protected String id, letterGrade;
    protected float midterm, assignments, exam, finalMark;

    // parameterized constructor
    public StudentRecord(String idNumber, float midtermMark, float assignmentsMark, float examMark) {
        id = idNumber;
        midterm = midtermMark;
        assignments = assignmentsMark;
        exam = examMark;
        finalMark = 0;
        letterGrade = "";
    }

    // initializes new values for the student record
    // NOTE: The final mark and letter grade are not entered, they are calculated
    //       using the calculateFinalMark() and calculateLetterGrade() methods.
    private void add(StudentRecord record) {
        id = record.getId();
        midterm = record.getMidterm();
        assignments = record.getAssignments();
        exam = record.getExam();
    }

    // gets the current id value
    public String getId() {
        return id;
    }

    // sets a new id value
    public void setId(String id) {
        this.id = id;
    }

    // gets the current midterm value
    public float getMidterm() {
        return midterm;
    }
    // sets a new midterm value
    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    // gets the current assignment value
    public float getAssignments() {
        return assignments;
    }

    // sets a new assignment value
    public void setAssignments(float assignments) {
        this.assignments = assignments;
    }

    // gets the current exam value
    public float getExam() {
        return exam;
    }

    // sets a new exam value
    public void setExam(float exam) {
        this.exam = exam;
    }

    // gets the current letter grade
    public String getLetterGrade() {
        return letterGrade;
    }

    // sets a new letter grade
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    // gets the current final mark value
    public float getFinalMark() {
        return finalMark;
    }

    // sets a new final mark value
    public void setFinalMark(float finalMark) {
        this.finalMark = finalMark;
    }
}
