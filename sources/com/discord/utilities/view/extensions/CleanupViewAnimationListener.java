package com.discord.utilities.view.extensions;

import android.animation.Animator;
import android.view.View;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CleanupViewAnimationListener implements Animator.AnimatorListener {
    private final View view;

    public CleanupViewAnimationListener(View view) {
        C12238m.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final View getView() {
        return this.view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        ViewExtensions.fadeAnimations.remove(this.view);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        ViewExtensions.fadeAnimations.remove(this.view);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
    }
}
