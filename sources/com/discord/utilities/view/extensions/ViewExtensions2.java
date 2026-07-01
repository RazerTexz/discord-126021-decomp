package com.discord.utilities.view.extensions;

import android.animation.Animator;
import android.view.View;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.view.extensions.CleanupViewAnimationListener, reason: use source file name */
/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions2 implements Animator.AnimatorListener {
    private final View view;

    public ViewExtensions2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
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
