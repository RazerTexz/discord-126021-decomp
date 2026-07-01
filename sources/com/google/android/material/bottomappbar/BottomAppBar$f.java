package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$f extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public BottomAppBar$f(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar.access$1600(this.a);
        BottomAppBar.access$002(this.a, false);
        BottomAppBar.access$1902(this.a, null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        BottomAppBar.access$1500(this.a);
    }
}
