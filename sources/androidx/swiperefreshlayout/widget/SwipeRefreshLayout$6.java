package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout$6 extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$6(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.this$0;
        int iAbs = !swipeRefreshLayout.mUsingCustomStart ? swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop) : swipeRefreshLayout.mSpinnerOffsetEnd;
        SwipeRefreshLayout swipeRefreshLayout2 = this.this$0;
        int i = swipeRefreshLayout2.mFrom;
        this.this$0.setTargetOffsetTopAndBottom((i + ((int) ((iAbs - i) * f))) - swipeRefreshLayout2.mCircleView.getTop());
        this.this$0.mProgress.setArrowScale(1.0f - f);
    }
}
