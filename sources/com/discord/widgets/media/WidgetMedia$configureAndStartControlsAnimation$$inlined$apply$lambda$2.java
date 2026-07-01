package com.discord.widgets.media;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animation) {
        m.checkNotNullParameter(animation, "animation");
        WidgetMedia.access$setControlsAnimationAction$p(this.this$0, null);
    }
}
