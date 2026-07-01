package com.jaredrummler.android.colorpicker;

import android.view.View;
import android.view.View$OnLongClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$a implements View$OnLongClickListener {
    public final /* synthetic */ ColorPanelView j;

    public ColorPickerDialog$a(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView) {
        this.j = colorPanelView;
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(View view) {
        this.j.a();
        return true;
    }
}
