package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$i extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar a;

    public BottomAppBar$i(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.fabAnimationListener.onAnimationStart(animator);
        FloatingActionButton floatingActionButtonAccess$2200 = BottomAppBar.access$2200(this.a);
        if (floatingActionButtonAccess$2200 != null) {
            floatingActionButtonAccess$2200.setTranslationX(BottomAppBar.access$2300(this.a));
        }
    }
}
