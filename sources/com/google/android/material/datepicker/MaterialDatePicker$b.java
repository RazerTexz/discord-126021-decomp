package com.google.android.material.datepicker;

import android.view.View;
import android.view.View$OnClickListener;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialDatePicker$b implements View$OnClickListener {
    public final /* synthetic */ MaterialDatePicker j;

    public MaterialDatePicker$b(MaterialDatePicker materialDatePicker) {
        this.j = materialDatePicker;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        Iterator it = MaterialDatePicker.access$100(this.j).iterator();
        while (it.hasNext()) {
            ((View$OnClickListener) it.next()).onClick(view);
        }
        this.j.dismiss();
    }
}
