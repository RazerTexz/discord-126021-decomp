package com.google.android.material.timepicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialTimePicker$d implements View$OnClickListener {
    public final /* synthetic */ MaterialTimePicker j;

    public MaterialTimePicker$d(MaterialTimePicker materialTimePicker) {
        this.j = materialTimePicker;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        MaterialTimePicker materialTimePicker = this.j;
        MaterialTimePicker.access$402(materialTimePicker, MaterialTimePicker.access$400(materialTimePicker) == 0 ? 1 : 0);
        MaterialTimePicker materialTimePicker2 = this.j;
        MaterialTimePicker.access$600(materialTimePicker2, MaterialTimePicker.access$500(materialTimePicker2));
    }
}
