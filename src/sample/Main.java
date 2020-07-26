package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.controller.Controller;
import sample.workwithfile.FromFileDto;
import sample.workwithfile.FileLoader;
import sample.workwithfile.FileSaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class for GUI
 */
public class Main extends Application {
    private static final String SAVE_BUTTON_TEXT = "Сохранить";
    private static final String EXECUTE_BUTTON_TEXT = "Посчитать";
    private static final String LOAD_BUTTON_TEXT = "Загрузить";
    private static final String TASK1_TEXT = "Задание 1";
    private static final String TASK2_TEXT = "Задание 2";
    private static final String RESULT_TEXT = "Результат: ";

    /**
     * Method to draw GUI
     *
     * @param primaryStage primary stage used to start
     * @throws Exception never throws exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        final FileChooser fileChooser = new FileChooser();
        //First Panel
        Button saveButton = new Button(SAVE_BUTTON_TEXT);
        Button loadButton = new Button(LOAD_BUTTON_TEXT);
        Button executeButton = new Button(EXECUTE_BUTTON_TEXT);
        HBox saveLoadExecuteBox = new HBox(20);
        saveLoadExecuteBox.getChildren().addAll(executeButton, saveButton, loadButton);


        //Second Panel
        Label task1Label1 = new Label(TASK1_TEXT);
        TextArea textFieldTask1 = new TextArea();
        textFieldTask1.setPrefRowCount(2);
        Label task1Label2 = new Label(RESULT_TEXT);
        TextField textFieldTask1Result = new TextField();
        VBox task1VerticalBox = new VBox();

        VBox task2VerticalBox = new VBox();
        Label task2Label = new Label(TASK2_TEXT);
        TextField textFieldTask2 = new TextField();
        task1VerticalBox.getChildren().addAll(task1Label1, textFieldTask1, task1Label2, textFieldTask1Result);
        Label task2Label2 = new Label(RESULT_TEXT);
        TextField textFieldTask2Result = new TextField();
        task2VerticalBox.getChildren().addAll(task2Label, textFieldTask2, task2Label2, textFieldTask2Result);
        task2VerticalBox.setVisible(false);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(task1VerticalBox, task2VerticalBox);


        //Third Panel
        RadioButton task1Button = new RadioButton(TASK1_TEXT);
        RadioButton task2Button = new RadioButton(TASK2_TEXT);
        task1Button.setSelected(true);
        ToggleGroup group = new ToggleGroup();
        task1Button.setToggleGroup(group);
        task2Button.setToggleGroup(group);
        VBox radioButtonBox = new VBox();
        task1Button.setOnAction(e -> {
            task1VerticalBox.setVisible(true);
            task2VerticalBox.setVisible(false);
        });
        task2Button.setOnAction(e -> {
            task1VerticalBox.setVisible(false);
            task2VerticalBox.setVisible(true);
        });
        radioButtonBox.getChildren().addAll(task1Button, task2Button);

        Label errorText = new Label();
        errorText.setVisible(false);
        errorText.setTextFill(Color.RED);

        executeButton.setOnAction(e -> {
            try {
                if (task1Button.isSelected()) {
                    textFieldTask1Result.setText(new Controller().executeFirstTask(textFieldTask1.getText()));
                } else {
                    textFieldTask2Result.setText(new Controller().executeSecondTask(textFieldTask2.getText()));
                }
            } catch (RuntimeException exception) {
                errorText.setVisible(true);
                errorText.setText(exception.getMessage());
            }
        });

        saveButton.setOnAction(e -> {
            try {
                if (task1Button.isSelected()) {
                    new FileSaver().saveToFile(1, textFieldTask1.getText());
                } else {
                    new FileSaver().saveToFile(2, textFieldTask2.getText());
                }
            } catch (IOException exception) {
                errorText.setVisible(true);
                errorText.setText(exception.getMessage());
            }
        });

        loadButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    FromFileDto fromFileDto = new FileLoader().loadFromFile(file.getName());
                    int typeOfTask = fromFileDto.getTypeOfTask();
                    String input = fromFileDto.getText();
                    if (typeOfTask == 1) {
                        task1Button.fire();
                        textFieldTask1.setText(input);
                        executeButton.fire();
                    } else {
                        if (typeOfTask == 2) {
                            task2Button.fire();
                            textFieldTask2.setText(input);
                            executeButton.fire();
                        } else {
                            throw new RuntimeException("Неверный тип задачи в файле");
                        }
                    }
                } catch (RuntimeException exception) {
                    errorText.setVisible(true);
                    errorText.setText(exception.getMessage());
                } catch (FileNotFoundException exception) {
                    errorText.setVisible(true);
                    errorText.setText("Файл не найден");
                }
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(saveLoadExecuteBox, stackPane, radioButtonBox, errorText);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("It-Service");
        primaryStage.setWidth(500);
        primaryStage.setHeight(250);
        primaryStage.show();
    }

    /**
     * Method to  start program
     *
     * @param args arguments for program
     */
    public static void main(String[] args) {
        launch(args);
    }
}
