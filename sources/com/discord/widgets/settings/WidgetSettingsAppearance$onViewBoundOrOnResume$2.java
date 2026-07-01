package com.discord.widgets.settings;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettingsSystem;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$onViewBoundOrOnResume$2 extends o implements Function1<Integer, Unit> {
    public static final WidgetSettingsAppearance$onViewBoundOrOnResume$2 INSTANCE = new WidgetSettingsAppearance$onViewBoundOrOnResume$2();

    public WidgetSettingsAppearance$onViewBoundOrOnResume$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        StoreUserSettingsSystem userSettingsSystem = StoreStream.Companion.getUserSettingsSystem();
        m.checkNotNullExpressionValue(num, "fontScale");
        userSettingsSystem.setFontScale(num.intValue());
    }
}
