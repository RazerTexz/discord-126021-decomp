package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarWidgetWrapper$2 extends ViewPropertyAnimatorListenerAdapter {
    private boolean mCanceled = false;
    public final /* synthetic */ ToolbarWidgetWrapper this$0;
    public final /* synthetic */ int val$visibility;

    public ToolbarWidgetWrapper$2(ToolbarWidgetWrapper toolbarWidgetWrapper, int i) {
        this.this$0 = toolbarWidgetWrapper;
        this.val$visibility = i;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        if (this.mCanceled) {
            return;
        }
        this.this$0.mToolbar.setVisibility(this.val$visibility);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        this.this$0.mToolbar.setVisibility(0);
    }
}
