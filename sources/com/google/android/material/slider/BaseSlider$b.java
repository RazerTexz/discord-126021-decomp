package com.google.android.material.slider;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import androidx.core.view.ViewCompat;
import com.google.android.material.tooltip.TooltipDrawable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSlider$b implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ BaseSlider a;

    public BaseSlider$b(BaseSlider baseSlider) {
        this.a = baseSlider;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator it = BaseSlider.access$100(this.a).iterator();
        while (it.hasNext()) {
            ((TooltipDrawable) it.next()).setRevealFraction(fFloatValue);
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }
}
