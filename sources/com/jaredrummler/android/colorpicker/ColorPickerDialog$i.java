package com.jaredrummler.android.colorpicker;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$i implements Runnable {
    public final /* synthetic */ ColorPanelView j;
    public final /* synthetic */ int k;

    public ColorPickerDialog$i(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView, int i) {
        this.j = colorPanelView;
        this.k = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.setColor(this.k);
    }
}
