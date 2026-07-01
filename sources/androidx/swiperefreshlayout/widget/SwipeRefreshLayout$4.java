package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout$4 extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;
    public final /* synthetic */ int val$endingAlpha;
    public final /* synthetic */ int val$startingAlpha;

    public SwipeRefreshLayout$4(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.this$0 = swipeRefreshLayout;
        this.val$startingAlpha = i;
        this.val$endingAlpha = i2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        CircularProgressDrawable circularProgressDrawable = this.this$0.mProgress;
        int i = this.val$startingAlpha;
        circularProgressDrawable.setAlpha((int) (((this.val$endingAlpha - i) * f) + i));
    }
}
