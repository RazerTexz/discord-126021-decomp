package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$viewModel$2 extends o implements Function0<WidgetGuildScheduledEventCreateSuccessViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess$viewModel$2(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(0);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildScheduledEventCreateSuccessViewModel invoke() {
        Long lAccess$getChannelId$p = WidgetGuildScheduledEventCreateSuccess.access$getChannelId$p(this.this$0);
        long jAccess$getGuildId$p = WidgetGuildScheduledEventCreateSuccess.access$getGuildId$p(this.this$0);
        long jAccess$getGuildScheduledEventId$p = WidgetGuildScheduledEventCreateSuccess.access$getGuildScheduledEventId$p(this.this$0);
        Resources resources = this.this$0.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return new WidgetGuildScheduledEventCreateSuccessViewModel(lAccess$getChannelId$p, jAccess$getGuildId$p, jAccess$getGuildScheduledEventId$p, null, null, null, null, null, null, null, null, resources, 2040, null);
    }
}
