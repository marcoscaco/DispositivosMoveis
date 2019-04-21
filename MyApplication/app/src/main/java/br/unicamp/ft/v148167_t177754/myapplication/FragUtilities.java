package br.unicamp.ft.v148167_t177754.myapplication;

import android.widget.EditText;
import android.widget.Spinner;

public class FragUtilities {

    public void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setCursorVisible(false);

    }

    public void disableSpinner(Spinner spinner){
        spinner.setClickable(false);
        spinner.setFocusable(false);

    }

}
