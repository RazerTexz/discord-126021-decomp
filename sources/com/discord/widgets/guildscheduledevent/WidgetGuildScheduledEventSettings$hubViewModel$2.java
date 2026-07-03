package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$hubViewModel$2 extends AbstractC12240o implements Function0<GuildScheduledEventDirectoryAssociationViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$hubViewModel$2(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(0);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDirectoryAssociationViewModel invoke() {
        return new GuildScheduledEventDirectoryAssociationViewModel(this.this$0.getGuildId(), this.this$0.getExistingGuildScheduledEventId(), null, null, 12, null);
    }
}
