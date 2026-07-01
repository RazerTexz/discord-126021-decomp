package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess6 extends Lambda implements Function0<WidgetGuildScheduledEventCreateSuccessViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess6(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(0);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildScheduledEventCreateSuccessViewModel invoke() {
        Long channelId = this.this$0.getChannelId();
        long guildId = this.this$0.getGuildId();
        long guildScheduledEventId = this.this$0.getGuildScheduledEventId();
        Resources resources = this.this$0.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return new WidgetGuildScheduledEventCreateSuccessViewModel(channelId, guildId, guildScheduledEventId, null, null, null, null, null, null, null, null, resources, 2040, null);
    }
}
