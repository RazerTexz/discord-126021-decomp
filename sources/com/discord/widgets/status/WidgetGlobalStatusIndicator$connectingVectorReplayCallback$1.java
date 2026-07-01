package com.discord.widgets.status;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1 extends Animatable2Compat$AnimationCallback {
    public final /* synthetic */ WidgetGlobalStatusIndicator this$0;

    public WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        this.this$0 = widgetGlobalStatusIndicator;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        m.checkNotNullParameter(drawable, "drawable");
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatAccess$getConnectingVector$p = WidgetGlobalStatusIndicator.access$getConnectingVector$p(this.this$0);
        if (animatedVectorDrawableCompatAccess$getConnectingVector$p != null) {
            animatedVectorDrawableCompatAccess$getConnectingVector$p.start();
        }
    }
}
