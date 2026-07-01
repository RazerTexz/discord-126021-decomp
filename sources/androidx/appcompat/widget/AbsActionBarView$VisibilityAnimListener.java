package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: loaded from: classes.dex */
public class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener {
    private boolean mCanceled = false;
    public int mFinalVisibility;
    public final /* synthetic */ AbsActionBarView this$0;

    public AbsActionBarView$VisibilityAnimListener(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        if (this.mCanceled) {
            return;
        }
        AbsActionBarView absActionBarView = this.this$0;
        absActionBarView.mVisibilityAnim = null;
        AbsActionBarView.access$101(absActionBarView, this.mFinalVisibility);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        AbsActionBarView.access$001(this.this$0, 0);
        this.mCanceled = false;
    }

    public AbsActionBarView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
        this.this$0.mVisibilityAnim = viewPropertyAnimatorCompat;
        this.mFinalVisibility = i;
        return this;
    }
}
