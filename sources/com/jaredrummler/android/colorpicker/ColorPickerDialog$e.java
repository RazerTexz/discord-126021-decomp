package com.jaredrummler.android.colorpicker;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.Button;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$e implements View$OnClickListener {
    public final /* synthetic */ ColorPickerDialog j;

    public ColorPickerDialog$e(ColorPickerDialog colorPickerDialog) {
        this.j = colorPickerDialog;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.j.m.removeAllViews();
        ColorPickerDialog colorPickerDialog = this.j;
        int i = colorPickerDialog.p;
        if (i == 0) {
            colorPickerDialog.p = 1;
            Button button = (Button) view;
            int i2 = colorPickerDialog.J;
            if (i2 == 0) {
                i2 = R$e.cpv_custom;
            }
            button.setText(i2);
            ColorPickerDialog colorPickerDialog2 = this.j;
            colorPickerDialog2.m.addView(colorPickerDialog2.j());
            return;
        }
        if (i != 1) {
            return;
        }
        colorPickerDialog.p = 0;
        Button button2 = (Button) view;
        int i3 = colorPickerDialog.H;
        if (i3 == 0) {
            i3 = R$e.cpv_presets;
        }
        button2.setText(i3);
        ColorPickerDialog colorPickerDialog3 = this.j;
        colorPickerDialog3.m.addView(colorPickerDialog3.i());
    }
}
