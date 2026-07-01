package com.jaredrummler.android.colorpicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$c implements View$OnClickListener {
    public final /* synthetic */ ColorPickerDialog j;

    public ColorPickerDialog$c(ColorPickerDialog colorPickerDialog) {
        this.j = colorPickerDialog;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        ColorPickerDialog colorPickerDialog = this.j;
        ColorPickerDialog.g(colorPickerDialog, colorPickerDialog.o);
        this.j.dismiss();
    }
}
