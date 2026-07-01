package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import b.i.a.g.d.c;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;

/* JADX INFO: loaded from: classes3.dex */
public class SingleDateSelector$a extends c {
    public final /* synthetic */ OnSelectionChangedListener p;
    public final /* synthetic */ SingleDateSelector q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleDateSelector$a(SingleDateSelector singleDateSelector, String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener) {
        super(str, dateFormat, textInputLayout, calendarConstraints);
        this.q = singleDateSelector;
        this.p = onSelectionChangedListener;
    }

    @Override // b.i.a.g.d.c
    public void a() {
        this.p.onIncompleteSelectionChanged();
    }

    @Override // b.i.a.g.d.c
    public void b(@Nullable Long l) {
        if (l == null) {
            SingleDateSelector.access$000(this.q);
        } else {
            this.q.select(l.longValue());
        }
        this.p.onSelectionChanged(this.q.getSelection());
    }
}
