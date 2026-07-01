package com.google.android.material.datepicker;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView$State;
import b.i.a.g.d.j;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$c extends j {
    public final /* synthetic */ int j;
    public final /* synthetic */ MaterialCalendar k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialCalendar$c(MaterialCalendar materialCalendar, Context context, int i, boolean z2, int i2) {
        super(context, i, z2);
        this.k = materialCalendar;
        this.j = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(@NonNull RecyclerView$State recyclerView$State, @NonNull int[] iArr) {
        if (this.j == 0) {
            iArr[0] = MaterialCalendar.access$000(this.k).getWidth();
            iArr[1] = MaterialCalendar.access$000(this.k).getWidth();
        } else {
            iArr[0] = MaterialCalendar.access$000(this.k).getHeight();
            iArr[1] = MaterialCalendar.access$000(this.k).getHeight();
        }
    }
}
