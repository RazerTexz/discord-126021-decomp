package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildScheduledEventDetailsViewModel$1 extends k implements Function1<GuildScheduledEventDetailsViewModel$StoreState, Unit> {
    public GuildScheduledEventDetailsViewModel$1(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel) {
        super(1, guildScheduledEventDetailsViewModel, GuildScheduledEventDetailsViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel$StoreState guildScheduledEventDetailsViewModel$StoreState) {
        invoke2(guildScheduledEventDetailsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventDetailsViewModel$StoreState guildScheduledEventDetailsViewModel$StoreState) {
        m.checkNotNullParameter(guildScheduledEventDetailsViewModel$StoreState, "p1");
        GuildScheduledEventDetailsViewModel.access$handleStoreState((GuildScheduledEventDetailsViewModel) this.receiver, guildScheduledEventDetailsViewModel$StoreState);
    }
}
