package com.discord.utilities.views;

import android.R$animator;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.view.View;
import d0.z.d.m;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer$animatorFactoryFadeIn$1 implements FloatingButtonMenuInitializer$AnimatorFactory<View> {
    public final /* synthetic */ FloatingButtonMenuInitializer this$0;

    public FloatingButtonMenuInitializer$animatorFactoryFadeIn$1(FloatingButtonMenuInitializer floatingButtonMenuInitializer) {
        this.this$0 = floatingButtonMenuInitializer;
    }

    @Override // com.discord.utilities.views.FloatingButtonMenuInitializer$AnimatorFactory
    public Animator createAnimator(View view) {
        m.checkNotNullParameter(view, "view");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(FloatingButtonMenuInitializer.access$getContext$p(this.this$0), R$animator.fade_in);
        animatorLoadAnimator.setTarget(view);
        return animatorLoadAnimator;
    }
}
