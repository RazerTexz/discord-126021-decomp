package com.discord.utilities.view.extensions;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$fadeOut$viewPropertyAnimator$1 implements Runnable {
    public final /* synthetic */ Function0 $onAnimationEnd;
    public final /* synthetic */ View $view;

    public ViewExtensions$fadeOut$viewPropertyAnimator$1(View view, Function0 function0) {
        this.$view = view;
        this.$onAnimationEnd = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$view.setVisibility(8);
        this.$onAnimationEnd.invoke();
    }
}
