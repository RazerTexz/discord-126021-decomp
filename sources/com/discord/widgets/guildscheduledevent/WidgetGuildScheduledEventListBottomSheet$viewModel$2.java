package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet$viewModel$2 extends AbstractC12240o implements Function0<GuildScheduledEventListViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventListBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventListBottomSheet$viewModel$2(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventListBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventListViewModel invoke() {
        return new GuildScheduledEventListViewModel(this.this$0.getGuildId(), this.this$0.getChannelId(), null, null, null, null, null, null, null, 508, null);
    }
}
