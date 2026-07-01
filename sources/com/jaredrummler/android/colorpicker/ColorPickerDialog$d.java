package com.jaredrummler.android.colorpicker;

import android.util.Log;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.core.view.KeyEventDispatcher$Component;
import b.k.a.a.f;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$d implements View$OnClickListener {
    public final /* synthetic */ ColorPickerDialog j;

    public ColorPickerDialog$d(ColorPickerDialog colorPickerDialog) {
        this.j = colorPickerDialog;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        ColorPickerDialog colorPickerDialog = this.j;
        if (colorPickerDialog.k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            colorPickerDialog.k.onColorReset(colorPickerDialog.q);
        } else {
            KeyEventDispatcher$Component activity = colorPickerDialog.getActivity();
            if (!(activity instanceof f)) {
                throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
            }
            ((f) activity).onColorReset(colorPickerDialog.q);
        }
        this.j.dismiss();
    }
}
