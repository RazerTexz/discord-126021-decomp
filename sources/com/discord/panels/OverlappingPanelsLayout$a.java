package com.discord.panels;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import d0.z.d.m;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class OverlappingPanelsLayout$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2757b;

    public OverlappingPanelsLayout$a(int i, Object obj) {
        this.a = i;
        this.f2757b = obj;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        if (i == 0) {
            OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) this.f2757b;
            m.checkExpressionValueIsNotNull(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
            OverlappingPanelsLayout.access$updateCenterPanelX(overlappingPanelsLayout, ((Float) animatedValue).floatValue());
            return;
        }
        if (i != 1) {
            throw null;
        }
        OverlappingPanelsLayout overlappingPanelsLayout2 = (OverlappingPanelsLayout) this.f2757b;
        m.checkExpressionValueIsNotNull(valueAnimator, "animator");
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        if (animatedValue2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
        OverlappingPanelsLayout.access$updateCenterPanelX(overlappingPanelsLayout2, ((Float) animatedValue2).floatValue());
    }
}
