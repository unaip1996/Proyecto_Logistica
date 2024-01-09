package Util;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

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
}
