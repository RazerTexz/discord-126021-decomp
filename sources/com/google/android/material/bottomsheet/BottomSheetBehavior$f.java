package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$f implements Runnable {
    public final View j;
    public boolean k;
    public int l;
    public final /* synthetic */ BottomSheetBehavior m;

    public BottomSheetBehavior$f(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.m = bottomSheetBehavior;
        this.j = view;
        this.l = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewDragHelper viewDragHelper = this.m.viewDragHelper;
        if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
            this.m.setStateInternal(this.l);
        } else {
            ViewCompat.postOnAnimation(this.j, this);
        }
        this.k = false;
    }
}
