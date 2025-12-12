package com.sagar.weather.ui;

import java.io.FileInputStream;
import com.sagar.weather.service.WeatherService;
import com.sagar.weather.service.WeatherViewModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WeatherAppDesiredUI extends Application {
    private String myCity;
    private String myDescription;

    @Override
    public void start(Stage primaryStage) throws Exception {
        WeatherService service = new WeatherService();

        Image image1 = new Image(new FileInputStream("src/main/java/com/sagar/weather/img/settings.png"));
        Image image2 = new Image(new FileInputStream("src/main/java/com/sagar/weather/img/refresh.png"));
        ImageView view1 = new ImageView(image1);
        ImageView view2 = new ImageView(image2);

        view1.setFitHeight(50);
        view1.setFitWidth(50);
        view2.setFitHeight(50);
        view2.setFitWidth(50);
        Button img1 = new Button();
        Button img2 = new Button();
        img1.setGraphic(view1);
        img2.setGraphic(view2);

        img1.setStyle("-fx-background-color: transparent");
        img2.setStyle("-fx-background-color: transparent");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(img2, img1);
        hbox.setSpacing(1);

        HBox hbox2 = new HBox();
        Label label1 = new Label("Your City");
        label1.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 80));
        label1.setTextFill(Color.WHITE);
        Label label2 = new Label("Your feels like. . . ");
        label2.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 80));
        label2.setTextFill(Color.WHITE);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(label1, label2);
        hbox2.setSpacing(10);

        ImageView temperature = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/temp.png")));
        temperature.setFitHeight(50);
        temperature.setFitWidth(50);

        ImageView maxTemp = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/max.png")));
        maxTemp.setFitHeight(50);
        maxTemp.setFitWidth(50);

        ImageView minTemp = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/min.png")));
        minTemp.setFitHeight(50);
        minTemp.setFitWidth(50);

        ImageView speed = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/speed.png")));
        speed.setFitHeight(50);
        speed.setFitWidth(50);

        ImageView pressure = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/pressure.png")));
        pressure.setFitHeight(50);
        pressure.setFitWidth(50);

        ImageView sunrise = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/sunrise.png")));
        sunrise.setFitHeight(50);
        sunrise.setFitWidth(50);

        ImageView sunset = new ImageView(
                new Image(new FileInputStream("src/main/java/com/sagar/weather/img/sunset.png")));
        sunset.setFitHeight(50);
        sunset.setFitWidth(50);

        // labels
        Label tempLabel = new Label();
        tempLabel.setTextFill(Color.WHITE);
        tempLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Label maxTempLabel = new Label();
        maxTempLabel.setTextFill(Color.WHITE);
        maxTempLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        tempLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Label minTempLabel = new Label();
        minTempLabel.setTextFill(Color.WHITE);
        minTempLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Label speedLabel = new Label();
        speedLabel.setTextFill(Color.WHITE);
        speedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Label pressureLabel = new Label();
        pressureLabel.setTextFill(Color.WHITE);
        pressureLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Label sunriseLabel = new Label();
        sunriseLabel.setTextFill(Color.WHITE);
        sunriseLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Label sunsetLabel = new Label();
        sunsetLabel.setTextFill(Color.WHITE);
        sunsetLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        GridPane conditionsLayout = new GridPane();
        conditionsLayout.setHgap(30);
        conditionsLayout.setVgap(30);
        conditionsLayout.setAlignment(Pos.CENTER);
        conditionsLayout.add(temperature, 0, 0);
        conditionsLayout.add(tempLabel, 1, 0);
        conditionsLayout.add(maxTemp, 0, 1);
        conditionsLayout.add(maxTempLabel, 1, 1);
        conditionsLayout.add(minTemp, 0, 2);
        conditionsLayout.add(minTempLabel, 1, 2);
        conditionsLayout.add(speed, 0, 3);
        conditionsLayout.add(speedLabel, 1, 3);
        conditionsLayout.add(pressure, 0, 4);
        conditionsLayout.add(pressureLabel, 1, 4);
        conditionsLayout.add(sunrise, 0, 5);
        conditionsLayout.add(sunriseLabel, 1, 5);
        conditionsLayout.add(sunset, 0, 6);
        conditionsLayout.add(sunsetLabel, 1, 6);
        img1.setOnMouseEntered(e -> img1.setStyle("-fx-background-color:        #ffffff22"));
        img1.setOnMouseExited(e -> img1.setStyle("-fx-background-color:        transparent"));
        img2.setOnMouseEntered(e -> img2.setStyle("-fx-background-color:        #ffffff22"));
        img2.setOnMouseExited(e -> img2.setStyle("-fx-background-color:        transparent"));
        img1.setOnMouseClicked(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("City popup");
            dialog.setHeaderText("Enter city");
            dialog.setContentText("Enter your city");

            dialog.showAndWait().ifPresent(city -> {
                myCity = city;
                service.fetchWeather(myCity).thenAccept(response -> {
                    WeatherViewModel vm = new WeatherViewModel(response);

                    Platform.runLater(() -> {
                        myDescription = vm.getDescription();
                        label1.setText(vm.getCityName() + " : ");
                        label2.setText(capitalize(myDescription));
                        tempLabel.setText(vm.getTemperature());
                        maxTempLabel.setText(vm.getTemp_max());
                        minTempLabel.setText(vm.getTemp_min());
                        speedLabel.setText(vm.getSpeed());
                        pressureLabel.setText(vm.getPressure());
                        sunriseLabel.setText(vm.getSunrise());
                        sunsetLabel.setText(vm.getSunset());
                    });
                }).exceptionally(ex -> {

                    Platform.runLater(() -> {
                        showError("Failed to fetch weather. Please check your API key and city.");
                    });
                    return null;
                });
            });
        });
        img2.setOnMouseClicked(event -> {
            service.fetchWeather(myCity).thenAccept(response -> {
                WeatherViewModel vm = new WeatherViewModel(response);

                Platform.runLater(() -> {
                    myDescription = vm.getDescription();
                    label1.setText(vm.getCityName() + " : ");
                    label2.setText(capitalize(vm.getDescription()));
                    tempLabel.setText(vm.getTemperature());
                    maxTempLabel.setText(vm.getTemp_max());
                    minTempLabel.setText(vm.getTemp_min());
                    speedLabel.setText(vm.getSpeed());
                    pressureLabel.setText(vm.getPressure());
                    sunriseLabel.setText(vm.getSunrise());
                    sunsetLabel.setText(vm.getSunset());
                });
            });
        });

        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);
        vBox1.getChildren().addAll(conditionsLayout);

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        conditionsLayout.setPadding(new Insets(10));
        root.getChildren().addAll(hbox, hbox2, vBox1);
        root.setStyle("-fx-background-color: #7c6af1ff");
        root.setSpacing(20);

        Scene scene = new Scene(root, 600, 400, Color.BLUE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Weather app alert ");
        alert.setHeaderText("oops something went wrong....");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(WeatherAppDesiredUI.class, args);
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
