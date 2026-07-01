package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver$OnPreDrawListener;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout$OnPreDrawListener implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ CoordinatorLayout this$0;

    public CoordinatorLayout$OnPreDrawListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        this.this$0.onChildViewsChanged(0);
        return true;
    }
}
