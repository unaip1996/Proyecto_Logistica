package Util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ViewUtils {

    public static boolean validateFields(String[] fields) {
        boolean valid = true;

        for (int i = 0; i < fields.length && valid; i++) {
            valid = fields[i] != null && !fields[i].trim().isEmpty();
        }

        return valid;
    }

    public static void initializeSpinner(Spinner spinner, int maxValue) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxValue);
        valueFactory.setValue(1);

        spinner.setValueFactory(valueFactory);
    }

    public static void setDecimalBehaviour(TextField textfield) {
        textfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*(\\.\\d*)?")) {
                    textfield.setText(oldValue);
                }
            }
        });
    }

    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }
}
