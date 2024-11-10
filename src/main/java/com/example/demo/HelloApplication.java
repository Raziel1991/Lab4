package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        String[] labelsText = new String[]{"Name", "Address", "Province", "City", "Postal Code", "Phone Number", "Email"};
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15)); // Adds padding to the entire layout
        pane.setHgap(10); // Horizontal spacing between columns
        pane.setVgap(10); // Vertical spacing between rows

        String[] computerScienceCourses = new String[]{"Python", "Java", "C#", "PHP"};
        String[] businessCourses = {"Business Management", "Marketing", "Accounting", "Economics"};
        List<String> courseSelection = new ArrayList<>();

        // Sets labels in the first column
        for (int i = 0; i < labelsText.length; ++i) {
            Label label = new Label(labelsText[i] + ": ");
            pane.add(label, 0, i);
        }

        // Create text fields
        TextField name = new TextField();
        TextField address = new TextField();
        TextField province = new TextField();
        TextField city = new TextField();
        TextField postalCode = new TextField();
        TextField phoneNumber = new TextField();
        TextField email = new TextField();

        // Sets text fields in the second column
        pane.add(name, 1, 0);
        pane.add(address, 1, 1);
        pane.add(province, 1, 2);
        pane.add(city, 1, 3);
        pane.add(postalCode, 1, 4);
        pane.add(phoneNumber, 1, 5);
        pane.add(email, 1, 6);

        // Create checkboxes
        CheckBox studentCouncilCB = new CheckBox("Student Council");
        CheckBox volunteerWorkCB = new CheckBox("Volunteer Work");

        // Sets checkboxes in the third column
        pane.add(studentCouncilCB, 2, 1);
        pane.add(volunteerWorkCB, 2, 5);

        // Radio button setup for course selection
        RadioButton computerScienceRadio = new RadioButton("Computer Science");
        RadioButton businessRadio = new RadioButton("Business");

        ToggleGroup group = new ToggleGroup();
        computerScienceRadio.setToggleGroup(group);
        businessRadio.setToggleGroup(group);
        computerScienceRadio.setSelected(true);

        // ComboBox and ListView setup
        ComboBox<String> courseComboBox = new ComboBox<>();
        courseComboBox.setItems(FXCollections.observableArrayList(computerScienceCourses));
        courseComboBox.setValue(computerScienceCourses[0]);

        ListView<String> courseList = new ListView<>();
        courseList.setPrefHeight(100);
        courseList.setPrefWidth(120);
        if (courseSelection != null) {
            courseList.setItems(FXCollections.observableArrayList(courseSelection));
        }

        // Button for adding courses
        Button addCourseButton = new Button("Add Course");

        // Layout for course selection controls
        Label courseLabel = new Label("Course Selector");
        HBox radioBox = new HBox(10, computerScienceRadio, businessRadio);
        radioBox.setPadding(new Insets(10, 0, 10, 0));
        HBox courseBox = new HBox(10, courseComboBox, addCourseButton);
        VBox courseVBox = new VBox(10, courseLabel, radioBox, courseBox, courseList);

        // Display button and TextArea for output
        Button displayButton = new Button("Display");
        TextArea textArea = new TextArea();
        textArea.setPrefHeight(150);
        textArea.setPrefWidth(350);

        // Add components to the GridPane
        pane.add(courseVBox, 3, 0, 1, 7);
        GridPane.setHalignment(courseLabel, HPos.CENTER);
        GridPane.setColumnSpan(displayButton, 4);
        GridPane.setHalignment(displayButton, HPos.CENTER);
        pane.add(displayButton, 0, 7);
        GridPane.setColumnSpan(textArea, 4);
        pane.add(textArea, 0, 8);

        // Event handling
            //Toggle Buttons
        toggleSelection(computerScienceCourses, courseSelection, computerScienceRadio, courseComboBox, courseList);
        toggleSelection(businessCourses, courseSelection, businessRadio, courseComboBox, courseList);

            // Add Course Button
        addCourseButton.setOnMouseClicked(e -> {
            if (!courseSelection.contains(courseComboBox.getValue())) {
                courseSelection.add(courseComboBox.getValue());
                courseList.setItems(FXCollections.observableArrayList(courseSelection));
            }
        });

            // Display Button
        displayButton.setOnMouseClicked(e -> {
            UserData userData = new UserData(
                    name.getText(),
                    address.getText(),
                    province.getText(),
                    city.getText(),
                    postalCode.getText(),
                    phoneNumber.getText(),
                    email.getText(),
                    courseSelection
            );
            textArea.setText(userData.toString());
        });

        // Set up the scene and stage
        Scene scene = new Scene(pane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("User Registration Form");
        stage.show();
    }

    private void toggleSelection(String[] courses, List<String> courseSelection, RadioButton radioButton, ComboBox<String> courseComboBox, ListView<String> courseList) {
        radioButton.setOnAction(e -> {
            if (radioButton.isSelected()) {
                courseSelection.clear();
                courseList.setItems(FXCollections.observableArrayList(courseSelection));
                courseComboBox.setItems(FXCollections.observableArrayList(courses));
                courseComboBox.setValue(courses[0]);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
