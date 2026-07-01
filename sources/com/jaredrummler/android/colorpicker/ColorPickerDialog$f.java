package com.jaredrummler.android.colorpicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$f implements View$OnClickListener {
    public final /* synthetic */ ColorPickerDialog j;

    public ColorPickerDialog$f(ColorPickerDialog colorPickerDialog) {
        this.j = colorPickerDialog;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        int color = this.j.f3145y.getColor();
        ColorPickerDialog colorPickerDialog = this.j;
        int i = colorPickerDialog.o;
        if (color == i) {
            ColorPickerDialog.g(colorPickerDialog, i);
            this.j.dismiss();
        }
    }
}
