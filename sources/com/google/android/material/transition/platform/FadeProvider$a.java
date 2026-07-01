package com.google.android.material.transition.platform;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.View;
import b.i.a.g.l.l.k;

/* JADX INFO: loaded from: classes3.dex */
public class FadeProvider$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f3095b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;

    public FadeProvider$a(View view, float f, float f2, float f3, float f4) {
        this.a = view;
        this.f3095b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAlpha(k.e(this.f3095b, this.c, this.d, this.e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
    }
}
