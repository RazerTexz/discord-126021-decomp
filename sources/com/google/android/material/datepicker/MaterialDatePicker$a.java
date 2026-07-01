package com.google.android.material.datepicker;

import android.view.View;
import android.view.View$OnClickListener;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialDatePicker$a implements View$OnClickListener {
    public final /* synthetic */ MaterialDatePicker j;

    public MaterialDatePicker$a(MaterialDatePicker materialDatePicker) {
        this.j = materialDatePicker;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        Iterator it = MaterialDatePicker.access$000(this.j).iterator();
        while (it.hasNext()) {
            ((MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(this.j.getSelection());
        }
        this.j.dismiss();
    }
}
