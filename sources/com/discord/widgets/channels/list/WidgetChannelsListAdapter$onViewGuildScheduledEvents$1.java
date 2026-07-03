package com.discord.widgets.channels.list;

import com.discord.models.guild.Guild;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onViewGuildScheduledEvents$1 extends AbstractC12240o implements Function1<Guild, Unit> {
    public static final WidgetChannelsListAdapter$onViewGuildScheduledEvents$1 INSTANCE = new WidgetChannelsListAdapter$onViewGuildScheduledEvents$1();

    public WidgetChannelsListAdapter$onViewGuildScheduledEvents$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        C12238m.checkNotNullParameter(guild, "it");
    }
}
