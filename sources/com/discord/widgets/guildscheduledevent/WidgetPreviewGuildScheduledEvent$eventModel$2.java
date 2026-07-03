package com.discord.widgets.guildscheduledevent;

import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$eventModel$2 extends AbstractC12240o implements Function0<GuildScheduledEventModel> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent$eventModel$2(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
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
