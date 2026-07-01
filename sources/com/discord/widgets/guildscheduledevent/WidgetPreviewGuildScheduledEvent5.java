package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$eventModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent5 extends Lambda implements Function0<GuildScheduledEventModel> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent5(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        super(0);
        this.this$0 = widgetPreviewGuildScheduledEvent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventModel invoke() {
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra("INTENT_EXTRA_EVENT_MODEL");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.GuildScheduledEventModel");
        return (GuildScheduledEventModel) serializableExtra;
    }
}
