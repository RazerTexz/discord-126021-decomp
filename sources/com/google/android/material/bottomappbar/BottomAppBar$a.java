package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$a extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public BottomAppBar$a(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (BottomAppBar.access$000(this.a)) {
            return;
        }
        BottomAppBar bottomAppBar = this.a;
        BottomAppBar.access$300(bottomAppBar, BottomAppBar.access$100(bottomAppBar), BottomAppBar.access$200(this.a));
    }
}
