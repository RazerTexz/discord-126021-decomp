package com.google.android.material.bottomsheet;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$a implements Runnable {
    public final /* synthetic */ View j;
    public final /* synthetic */ int k;
    public final /* synthetic */ BottomSheetBehavior l;

    public BottomSheetBehavior$a(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.l = bottomSheetBehavior;
        this.j = view;
        this.k = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l.settleToState(this.j, this.k);
    }
}
