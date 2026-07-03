package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect$hubViewModel$2 extends AbstractC12240o implements Function0<GuildScheduledEventDirectoryAssociationViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelect$hubViewModel$2(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        super(0);
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDirectoryAssociationViewModel invoke() {
        return new GuildScheduledEventDirectoryAssociationViewModel(this.this$0.getGuildId(), this.this$0.getExistingGuildScheduledEventId(), null, null, 12, null);
    }
}
