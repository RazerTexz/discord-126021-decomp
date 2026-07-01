package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility$Model$Companion$get$1<T1, T2, T3, T4, R> implements Func4<Boolean, Boolean, Boolean, Integer, WidgetSettingsAccessibility$Model> {
    public static final WidgetSettingsAccessibility$Model$Companion$get$1 INSTANCE = new WidgetSettingsAccessibility$Model$Companion$get$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetSettingsAccessibility$Model call(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        return call2(bool, bool2, bool3, num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccessibility$Model call2(Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        m.checkNotNullExpressionValue(bool, "reducedMotionEnabled");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(bool2, "allowAnimatedEmoji");
        boolean zBooleanValue2 = bool2.booleanValue();
        m.checkNotNullExpressionValue(bool3, "autoPlayGifs");
        boolean zBooleanValue3 = bool3.booleanValue();
        m.checkNotNullExpressionValue(num, "currentStickerAnimationSettings");
        return new WidgetSettingsAccessibility$Model(zBooleanValue, zBooleanValue2, zBooleanValue3, num.intValue());
    }
}
