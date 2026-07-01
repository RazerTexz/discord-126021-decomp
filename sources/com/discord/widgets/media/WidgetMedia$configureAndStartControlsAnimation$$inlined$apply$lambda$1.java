package com.discord.widgets.media;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1 implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        m.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        AppBarLayout appBarLayout = WidgetMedia.access$getBinding$p(this.this$0).f2486b;
        m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        appBarLayout.setTranslationY(fFloatValue);
        if (!WidgetMedia.access$isVideo(this.this$0) || WidgetMedia.access$getPlayerControlsHeight$p(this.this$0) <= 0) {
            return;
        }
        float fAccess$getToolbarHeight$p = (-fFloatValue) / (WidgetMedia.access$getToolbarHeight$p(this.this$0) / WidgetMedia.access$getPlayerControlsHeight$p(this.this$0));
        PlayerControlView playerControlView = WidgetMedia.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
        playerControlView.setTranslationY(fAccess$getToolbarHeight$p);
    }
}
