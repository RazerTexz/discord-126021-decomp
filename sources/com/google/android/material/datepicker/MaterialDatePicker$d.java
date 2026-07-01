package com.google.android.material.datepicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialDatePicker$d implements View$OnClickListener {
    public final /* synthetic */ MaterialDatePicker j;

    public MaterialDatePicker$d(MaterialDatePicker materialDatePicker) {
        this.j = materialDatePicker;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        MaterialDatePicker.access$400(this.j).setEnabled(MaterialDatePicker.access$300(this.j).isSelectionComplete());
        MaterialDatePicker.access$500(this.j).toggle();
        MaterialDatePicker materialDatePicker = this.j;
        MaterialDatePicker.access$600(materialDatePicker, MaterialDatePicker.access$500(materialDatePicker));
        MaterialDatePicker.access$700(this.j);
    }
}
