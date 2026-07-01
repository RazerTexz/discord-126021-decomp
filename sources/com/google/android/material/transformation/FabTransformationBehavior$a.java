package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class FabTransformationBehavior$a extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3078b;
    public final /* synthetic */ View c;

    public FabTransformationBehavior$a(FabTransformationBehavior fabTransformationBehavior, boolean z2, View view, View view2) {
        this.a = z2;
        this.f3078b = view;
        this.c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.a) {
            return;
        }
        this.f3078b.setVisibility(4);
        this.c.setAlpha(1.0f);
        this.c.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.a) {
            this.f3078b.setVisibility(0);
            this.c.setAlpha(0.0f);
            this.c.setVisibility(4);
        }
    }
}
