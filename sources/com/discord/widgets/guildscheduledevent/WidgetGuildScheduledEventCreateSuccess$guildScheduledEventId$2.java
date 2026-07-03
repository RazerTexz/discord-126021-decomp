package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.intent.IntentUtilsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$guildScheduledEventId$2 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess$guildScheduledEventId$2(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(0);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Long longExtraOrNull = IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID");
        if (longExtraOrNull != null) {
            return longExtraOrNull.longValue();
        }
        throw new IllegalStateException();
    }
}
