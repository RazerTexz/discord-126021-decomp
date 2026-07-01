package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout$1 implements Animation$AnimationListener {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$1(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout$OnRefreshListener swipeRefreshLayout$OnRefreshListener;
        SwipeRefreshLayout swipeRefreshLayout = this.this$0;
        if (!swipeRefreshLayout.mRefreshing) {
            swipeRefreshLayout.reset();
            return;
        }
        swipeRefreshLayout.mProgress.setAlpha(255);
        this.this$0.mProgress.start();
        SwipeRefreshLayout swipeRefreshLayout2 = this.this$0;
        if (swipeRefreshLayout2.mNotify && (swipeRefreshLayout$OnRefreshListener = swipeRefreshLayout2.mListener) != null) {
            swipeRefreshLayout$OnRefreshListener.onRefresh();
        }
        SwipeRefreshLayout swipeRefreshLayout3 = this.this$0;
        swipeRefreshLayout3.mCurrentTargetOffsetTop = swipeRefreshLayout3.mCircleView.getTop();
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
