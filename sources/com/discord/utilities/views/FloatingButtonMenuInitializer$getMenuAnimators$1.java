package com.discord.utilities.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import d0.z.d.m;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer$getMenuAnimators$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup $row;

    public FloatingButtonMenuInitializer$getMenuAnimators$1(ViewGroup viewGroup) {
        this.$row = viewGroup;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animation) {
        m.checkNotNullParameter(animation, "animation");
        this.$row.setVisibility(0);
    }
}
