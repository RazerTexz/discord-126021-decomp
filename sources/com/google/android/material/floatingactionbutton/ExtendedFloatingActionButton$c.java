package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.i.a.g.e.j;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$c extends AnimatorListenerAdapter {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f3039b;
    public final /* synthetic */ ExtendedFloatingActionButton$OnChangedCallback c;

    public ExtendedFloatingActionButton$c(ExtendedFloatingActionButton extendedFloatingActionButton, j jVar, ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        this.f3039b = jVar;
        this.c = extendedFloatingActionButton$OnChangedCallback;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
        this.f3039b.a();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f3039b.e();
        if (this.a) {
            return;
        }
        this.f3039b.g(this.c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f3039b.onAnimationStart(animator);
        this.a = false;
    }
}
