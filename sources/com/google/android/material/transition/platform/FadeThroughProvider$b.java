package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class FadeThroughProvider$b extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f3098b;

    public FadeThroughProvider$b(View view, float f) {
        this.a = view;
        this.f3098b = f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setAlpha(this.f3098b);
    }
}
