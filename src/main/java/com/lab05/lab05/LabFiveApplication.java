package com.lab05.lab05;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

// * Outline:
// * - StudentID
// * - Midterm
// * - Assignments
// * - Final exam
// * - Final Mark
// * - Letter Grade

public class LabFiveApplication extends Application {
    // configuring the table -------------------------------------------------------------------------------------------

    // initializing the table
    TableView table = new TableView();

    // main function
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(table);
        stage.setTitle("Lab 05");
        stage.setMinHeight(300);
        stage.setMinWidth(605);

        // ensuring the table is mutable
        table.setEditable(true);

        // StudentID
        TableColumn<StudentRecord, String> studentIDCol = new TableColumn<StudentRecord, String>("Student ID:");
        studentIDCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("id"));
        studentIDCol.setMinWidth(50); // setting the minimum render width of the column

        // Midterm
        TableColumn<StudentRecord, Float> midtermCol = new TableColumn<StudentRecord, Float>("Midterm Mark:");
        midtermCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
        midtermCol.setMinWidth(100); // setting the minimum render width of the column

        // Assignments
        TableColumn<StudentRecord, Float> assignmentCol = new TableColumn<StudentRecord, Float>("Assignments Mark:");
        assignmentCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignments"));
        assignmentCol.setMinWidth(120); // setting the minimum render wi>dth of the column

        // Final Exam
        TableColumn<StudentRecord, Float> finalExamCol = new TableColumn<StudentRecord, Float>("Final Exam Mark:");
        finalExamCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("exam"));
        finalExamCol.setMinWidth(120); // setting the minimum render width of the column

        // Final Mark
        TableColumn<StudentRecord, Float> finalGradeCol = new TableColumn<StudentRecord, Float>("Final Mark:");
        finalGradeCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finalMark"));
        finalGradeCol.setMinWidth(50); // setting the minimum render width of the column

        // Letter Grade
        TableColumn<StudentRecord, String> letterGradeCol = new TableColumn<StudentRecord, String>("Letter Grade:");
        letterGradeCol.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letterGrade"));
        letterGradeCol.setMinWidth(50); // setting the minimum render width of the column

        // adding the data to the table --------------------------------------------------------------------------------
        // initializing the data in an observable list
        ObservableList<StudentRecord> data = DataSource.getAllMarks();

        // adding the final mark and letter grade values to the data
        for (StudentRecord datum : data) {
            // final mark
            datum.setFinalMark((float) calculateFinalMark(datum.getMidterm(), datum.getAssignments(), datum.getExam()));
            // letter grade
            datum.setLetterGrade(calculateLetterGrade(datum.getFinalMark()));
        }

        // adding the data to the table
        table.setItems(data);

        // adding the columns to the table
        table.getColumns().addAll(studentIDCol, midtermCol, assignmentCol, finalExamCol, finalGradeCol, letterGradeCol);


        // displaying the table ----------------------------------------------------------------------------------------
        stage.setScene(scene);
        stage.show();
    }

    // calculates the final grade using weighted averages
    // - Assignments (20%)
    // - Midterm (30%)
    // - Final Exam (50%)
    private double calculateFinalMark(float midtermMark, float assignmentsMark, float examMark) {
        return (midtermMark*0.3 + assignmentsMark*0.2 + examMark*0.5);
    }

    // calculates the letter grade
    // F - 49% and lower
    // D - Between 50% and 59%
    // C - Between 60% and 69%
    // B - Between 70% and 79%
    // A - Between 80% and 100%
    private String calculateLetterGrade(double intGrade) {
        if (intGrade > 0 && intGrade <= 49) {
            return "F";
        } else if (intGrade > 50 && intGrade < 60) {
            return "D";
        } else if (intGrade > 60 && intGrade < 70) {
            return  "C";
        } else if (intGrade > 70 && intGrade < 80) {
            return  "B";
        } else if (intGrade > 80 && intGrade <= 100) {
            return "A";
        } else { // catch
            return "!";
        }
    }
}