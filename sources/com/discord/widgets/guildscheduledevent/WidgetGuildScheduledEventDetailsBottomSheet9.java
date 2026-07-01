package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet9 extends Lambda implements Function0<GuildScheduledEventDetailsViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsBottomSheet9(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDetailsViewModel invoke() {
        return new GuildScheduledEventDetailsViewModel(this.this$0.getArgs(), null, null, null, null, null, null, null, null, null, null, null, null, 0, 16382, null);
    }
}
