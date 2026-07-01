package com.discord.views.segmentedcontrol;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SegmentedControlContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SegmentedControlContainer$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ SegmentedControlContainer k;

    public SegmentedControlContainer$a(int i, SegmentedControlContainer segmentedControlContainer) {
        this.j = i;
        this.k = segmentedControlContainer;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<? super Integer, Unit> function1 = this.k.segmentSelectedChangeListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.j));
        }
    }
}
