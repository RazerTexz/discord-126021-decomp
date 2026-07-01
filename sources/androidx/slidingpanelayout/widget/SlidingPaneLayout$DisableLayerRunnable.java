package androidx.slidingpanelayout.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout$DisableLayerRunnable implements Runnable {
    public final View mChildView;
    public final /* synthetic */ SlidingPaneLayout this$0;

    public SlidingPaneLayout$DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
        this.this$0 = slidingPaneLayout;
        this.mChildView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mChildView.getParent() == this.this$0) {
            this.mChildView.setLayerType(0, null);
            this.this$0.invalidateChildRegion(this.mChildView);
        }
        this.this$0.mPostedRunnables.remove(this);
    }
}
