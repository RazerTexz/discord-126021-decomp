package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet$guildId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventUpsellBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventUpsellBottomSheet3(WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventUpsellBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_GUILD_ID");
    }
}
