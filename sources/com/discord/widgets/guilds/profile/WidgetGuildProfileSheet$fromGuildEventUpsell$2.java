package com.discord.widgets.guilds.profile;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$fromGuildEventUpsell$2 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$fromGuildEventUpsell$2(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(0);
        this.this$0 = widgetGuildProfileSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getArgumentsOrDefault().getBoolean("EXTRA_FROM_UPSELL", false);
    }
}
