package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$viewModel$2 extends AbstractC12240o implements Function0<WidgetGuildScheduledEventCreateSuccessViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess$viewModel$2(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
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
        C12238m.checkNotNullExpressionValue(resources, "resources");
        return new WidgetGuildScheduledEventCreateSuccessViewModel(channelId, guildId, guildScheduledEventId, null, null, null, null, null, null, null, null, resources, 2040, null);
    }
}
