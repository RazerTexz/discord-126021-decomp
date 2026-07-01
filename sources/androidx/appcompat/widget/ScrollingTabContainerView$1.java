package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView$1 implements Runnable {
    public final /* synthetic */ ScrollingTabContainerView this$0;
    public final /* synthetic */ View val$tabView;

    public ScrollingTabContainerView$1(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.this$0 = scrollingTabContainerView;
        this.val$tabView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.smoothScrollTo(this.val$tabView.getLeft() - ((this.this$0.getWidth() - this.val$tabView.getWidth()) / 2), 0);
        this.this$0.mTabSelector = null;
    }
}
