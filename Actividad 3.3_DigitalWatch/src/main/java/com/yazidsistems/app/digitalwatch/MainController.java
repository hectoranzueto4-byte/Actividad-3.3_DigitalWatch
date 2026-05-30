package com.yazidsistems.app.digitalwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainController {

    @FXML
    private Label labelReloj;

    private Timeline timeline;

    @FXML
    public void initialize() {
        // Configurar el formato de hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Crear el Timeline para actualizar la hora cada segundo
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            String horaActual = LocalTime.now().format(formato);
            labelReloj.setText(horaActual);
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play(); // Iniciar el reloj
    }

    // Método para detener el reloj si es necesario liberar recursos
    public void detenerReloj() {
        if (timeline != null) {
            timeline.stop();
        }
    }
}
