package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout$5 implements Animation$AnimationListener {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$5(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.this$0;
        if (swipeRefreshLayout.mScale) {
            return;
        }
        swipeRefreshLayout.startScaleDownAnimation(null);
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
