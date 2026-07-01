package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$g extends AnimatorListenerAdapter {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f3030b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BottomAppBar e;

    public BottomAppBar$g(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z2) {
        this.e = bottomAppBar;
        this.f3030b = actionMenuView;
        this.c = i;
        this.d = z2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.a) {
            return;
        }
        boolean z2 = BottomAppBar.access$2000(this.e) != 0;
        BottomAppBar bottomAppBar = this.e;
        bottomAppBar.replaceMenu(BottomAppBar.access$2000(bottomAppBar));
        BottomAppBar.access$2100(this.e, this.f3030b, this.c, this.d, z2);
    }
}
