package com.google.android.material.timepicker;

import android.view.View;
import android.view.View$OnClickListener;
import com.google.android.material.R$id;

/* JADX INFO: loaded from: classes3.dex */
public class TimePickerView$a implements View$OnClickListener {
    public final /* synthetic */ TimePickerView j;

    public TimePickerView$a(TimePickerView timePickerView) {
        this.j = timePickerView;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        TimePickerView$d timePickerView$d = this.j.q;
        if (timePickerView$d != null) {
            timePickerView$d.b(((Integer) view.getTag(R$id.selection_type)).intValue());
        }
    }
}
