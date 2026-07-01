package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout$8 extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$8(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.this$0;
        float f2 = swipeRefreshLayout.mStartingScale;
        swipeRefreshLayout.setAnimationProgress(((-f2) * f) + f2);
        this.this$0.moveToStart(f);
    }
}
