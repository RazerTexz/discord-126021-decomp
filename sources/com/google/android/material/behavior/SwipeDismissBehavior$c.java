package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior$c implements Runnable {
    public final View j;
    public final boolean k;
    public final /* synthetic */ SwipeDismissBehavior l;

    public SwipeDismissBehavior$c(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z2) {
        this.l = swipeDismissBehavior;
        this.j = view;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener;
        ViewDragHelper viewDragHelper = this.l.viewDragHelper;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            ViewCompat.postOnAnimation(this.j, this);
        } else {
            if (!this.k || (swipeDismissBehavior$OnDismissListener = this.l.listener) == null) {
                return;
            }
            swipeDismissBehavior$OnDismissListener.onDismiss(this.j);
        }
    }
}
