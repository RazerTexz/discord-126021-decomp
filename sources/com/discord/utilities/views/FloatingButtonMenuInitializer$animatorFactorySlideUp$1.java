package com.discord.utilities.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import d0.z.d.m;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer$animatorFactorySlideUp$1 implements FloatingButtonMenuInitializer$AnimatorFactory<View> {
    @Override // com.discord.utilities.views.FloatingButtonMenuInitializer$AnimatorFactory
    public Animator createAnimator(View view) {
        m.checkNotNullParameter(view, "view");
        return ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getHeight() * 1.0f, 0.0f);
    }
}
