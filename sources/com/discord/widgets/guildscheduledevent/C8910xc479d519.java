package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.intent.IntentUtilsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$existingGuildScheduledEventId$2 */
/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8910xc479d519 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8910xc479d519(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(0);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID");
    }
}
