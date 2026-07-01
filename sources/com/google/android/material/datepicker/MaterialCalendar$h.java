package com.google.android.material.datepicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$h implements View$OnClickListener {
    public final /* synthetic */ MaterialCalendar j;

    public MaterialCalendar$h(MaterialCalendar materialCalendar) {
        this.j = materialCalendar;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.j.toggleVisibleSelector();
    }
}
