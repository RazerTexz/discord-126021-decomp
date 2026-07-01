package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tooltip.TooltipDrawable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSlider$c extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseSlider a;

    public BaseSlider$c(BaseSlider baseSlider) {
        this.a = baseSlider;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        Iterator it = BaseSlider.access$100(this.a).iterator();
        while (it.hasNext()) {
            ViewUtils.getContentViewOverlay(this.a).remove((TooltipDrawable) it.next());
        }
    }
}
