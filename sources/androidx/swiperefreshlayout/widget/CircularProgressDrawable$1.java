package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable$1 implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ CircularProgressDrawable this$0;
    public final /* synthetic */ CircularProgressDrawable$Ring val$ring;

    public CircularProgressDrawable$1(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable$Ring circularProgressDrawable$Ring) {
        this.this$0 = circularProgressDrawable;
        this.val$ring = circularProgressDrawable$Ring;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.this$0.updateRingColor(fFloatValue, this.val$ring);
        this.this$0.applyTransformation(fFloatValue, this.val$ring, false);
        this.this$0.invalidateSelf();
    }
}
