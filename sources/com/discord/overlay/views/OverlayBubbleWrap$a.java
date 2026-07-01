package com.discord.overlay.views;

import d0.b0.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayBubbleWrap$a extends a<Boolean> {
    public final /* synthetic */ OverlayBubbleWrap a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayBubbleWrap$a(Object obj, Object obj2, OverlayBubbleWrap overlayBubbleWrap) {
        super(obj2);
        this.a = overlayBubbleWrap;
    }

    @Override // d0.b0.a
    public void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
        m.checkNotNullParameter(kProperty, "property");
        boolean zBooleanValue = bool2.booleanValue();
        if (bool.booleanValue() == zBooleanValue) {
            return;
        }
        Function1<Boolean, Unit> onMovingStateChanged = this.a.getOnMovingStateChanged();
        if (onMovingStateChanged != null) {
            onMovingStateChanged.invoke(Boolean.valueOf(zBooleanValue));
        }
        if (zBooleanValue) {
            this.a.performHapticFeedback(1);
            this.a.getSpringAnimationX().cancel();
            this.a.getSpringAnimationY().cancel();
        }
        this.a.setPressed(zBooleanValue);
    }
}
