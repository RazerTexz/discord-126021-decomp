package com.discord.widgets.guilds.join;

import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$configureWelcomeChannels$goToChannel$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet4 extends Lambda implements Function2<Long, Integer, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ List $welcomeChannels;
    public final /* synthetic */ WidgetGuildWelcomeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheet4(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet, long j, List list) {
        super(2);
        this.this$0 = widgetGuildWelcomeSheet;
        this.$guildId = j;
        this.$welcomeChannels = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Integer num) {
        invoke(l.longValue(), num.intValue());
        return Unit.a;
    }

    public final void invoke(long j, int i) {
        this.this$0.getViewModel().onClickChannel(this.$guildId, j, i, this.$welcomeChannels);
    }
}
