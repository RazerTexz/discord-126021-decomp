package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class ScaleProvider$a extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f3092b;
    public final /* synthetic */ float c;

    public ScaleProvider$a(View view, float f, float f2) {
        this.a = view;
        this.f3092b = f;
        this.c = f2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setScaleX(this.f3092b);
        this.a.setScaleY(this.c);
    }
}
