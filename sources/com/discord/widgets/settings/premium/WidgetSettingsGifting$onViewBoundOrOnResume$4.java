package com.discord.widgets.settings.premium;

import b.a.a.a0.c;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$onViewBoundOrOnResume$4 extends o implements Function1<String, Unit> {
    public static final WidgetSettingsGifting$onViewBoundOrOnResume$4 INSTANCE = new WidgetSettingsGifting$onViewBoundOrOnResume$4();

    public WidgetSettingsGifting$onViewBoundOrOnResume$4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "giftCode");
        c.k.a(str, "Settings - Gifting", 0L);
    }
}
