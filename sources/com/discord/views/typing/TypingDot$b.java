package com.discord.views.typing;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TypingDot.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TypingDot$b implements Animation$AnimationListener {
    public final Function0<Unit> j;

    public TypingDot$b(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "onComplete");
        this.j = function0;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.j.invoke();
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
