package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet$channelId$2 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventListBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventListBottomSheet$channelId$2(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventListBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        long j = this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        if (j == -1) {
            return null;
        }
        return Long.valueOf(j);
    }
}
