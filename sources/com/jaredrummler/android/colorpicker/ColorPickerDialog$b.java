package com.jaredrummler.android.colorpicker;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$b implements View$OnTouchListener {
    public final /* synthetic */ ColorPickerDialog j;

    public ColorPickerDialog$b(ColorPickerDialog colorPickerDialog) {
        this.j = colorPickerDialog;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        EditText editText = this.j.A;
        if (view == editText || !editText.hasFocus()) {
            return false;
        }
        this.j.A.clearFocus();
        ((InputMethodManager) this.j.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.j.A.getWindowToken(), 0);
        this.j.A.clearFocus();
        return true;
    }
}
