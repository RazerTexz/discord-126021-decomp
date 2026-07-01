package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class SlideDistanceProvider$a extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f3093b;

    public SlideDistanceProvider$a(View view, float f) {
        this.a = view;
        this.f3093b = f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setTranslationX(this.f3093b);
    }
}
