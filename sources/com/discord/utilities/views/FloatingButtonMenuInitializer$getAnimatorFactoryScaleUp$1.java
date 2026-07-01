package com.discord.utilities.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import d0.z.d.m;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1 implements FloatingButtonMenuInitializer$AnimatorFactory<ViewGroup> {
    public final /* synthetic */ View $mainFab;

    public FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1(View view) {
        this.$mainFab = view;
    }

    @Override // com.discord.utilities.views.FloatingButtonMenuInitializer$AnimatorFactory
    public /* bridge */ /* synthetic */ Animator createAnimator(View view) {
        return createAnimator((ViewGroup) view);
    }

    public Animator createAnimator(ViewGroup view) {
        m.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.$mainFab, (Property<View, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.$mainFab, (Property<View, Float>) View.SCALE_Y, 0.0f, 1.0f));
        return animatorSet;
    }
}
