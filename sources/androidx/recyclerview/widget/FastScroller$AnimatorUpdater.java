package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

/* JADX INFO: loaded from: classes.dex */
public class FastScroller$AnimatorUpdater implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$AnimatorUpdater(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        this.this$0.mVerticalThumbDrawable.setAlpha(iFloatValue);
        this.this$0.mVerticalTrackDrawable.setAlpha(iFloatValue);
        this.this$0.requestRedraw();
    }
}
