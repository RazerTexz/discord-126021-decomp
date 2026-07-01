package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$d extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public BottomAppBar$d(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar.access$1600(this.a);
        BottomAppBar.access$1702(this.a, null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        BottomAppBar.access$1500(this.a);
    }
}
