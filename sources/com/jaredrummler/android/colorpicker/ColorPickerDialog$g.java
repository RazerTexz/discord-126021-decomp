package com.jaredrummler.android.colorpicker;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$g implements View$OnFocusChangeListener {
    public final /* synthetic */ ColorPickerDialog j;

    public ColorPickerDialog$g(ColorPickerDialog colorPickerDialog) {
        this.j = colorPickerDialog;
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view, boolean z2) {
        if (z2) {
            ((InputMethodManager) this.j.getActivity().getSystemService("input_method")).showSoftInput(this.j.A, 1);
        }
    }
}
