package com.google.android.material.timepicker;

import android.view.View;
import android.view.View$OnClickListener;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialTimePicker$c implements View$OnClickListener {
    public final /* synthetic */ MaterialTimePicker j;

    public MaterialTimePicker$c(MaterialTimePicker materialTimePicker) {
        this.j = materialTimePicker;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        Iterator it = MaterialTimePicker.access$900(this.j).iterator();
        while (it.hasNext()) {
            ((View$OnClickListener) it.next()).onClick(view);
        }
        this.j.dismiss();
    }
}
