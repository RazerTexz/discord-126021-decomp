package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$updateViews$$inlined$apply$lambda$2 implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ WidgetTabsHost this$0;

    public WidgetTabsHost$updateViews$$inlined$apply$lambda$2(WidgetTabsHost widgetTabsHost) {
        this.this$0 = widgetTabsHost;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TabsHostBottomNavigationView tabsHostBottomNavigationView = WidgetTabsHost.access$getBinding$p(this.this$0).f2664b;
        m.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
        m.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        tabsHostBottomNavigationView.setTranslationY(((Float) animatedValue).floatValue());
    }
}
