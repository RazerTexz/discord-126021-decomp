package com.discord.widgets.guildscheduledevent;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet$viewModel$2 extends o implements Function0<GuildScheduledEventListViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventListBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventListBottomSheet$viewModel$2(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventListBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventListViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventListViewModel invoke() {
        return new GuildScheduledEventListViewModel(WidgetGuildScheduledEventListBottomSheet.access$getGuildId$p(this.this$0), WidgetGuildScheduledEventListBottomSheet.access$getChannelId$p(this.this$0), null, null, null, null, null, null, null, 508, null);
    }
}
