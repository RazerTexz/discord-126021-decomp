package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import b.i.a.g.d.c;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;

/* JADX INFO: loaded from: classes3.dex */
public class RangeDateSelector$b extends c {
    public final /* synthetic */ TextInputLayout p;
    public final /* synthetic */ TextInputLayout q;
    public final /* synthetic */ OnSelectionChangedListener r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ RangeDateSelector f3038s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeDateSelector$b(RangeDateSelector rangeDateSelector, String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
        super(str, dateFormat, textInputLayout, calendarConstraints);
        this.f3038s = rangeDateSelector;
        this.p = textInputLayout2;
        this.q = textInputLayout3;
        this.r = onSelectionChangedListener;
    }

    @Override // b.i.a.g.d.c
    public void a() {
        RangeDateSelector.access$202(this.f3038s, null);
        RangeDateSelector.access$100(this.f3038s, this.p, this.q, this.r);
    }

    @Override // b.i.a.g.d.c
    public void b(@Nullable Long l) {
        RangeDateSelector.access$202(this.f3038s, l);
        RangeDateSelector.access$100(this.f3038s, this.p, this.q, this.r);
    }
}
