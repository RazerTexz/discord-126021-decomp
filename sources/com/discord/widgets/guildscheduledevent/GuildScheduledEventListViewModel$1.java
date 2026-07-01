package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildScheduledEventListViewModel$1 extends k implements Function1<GuildScheduledEventListViewModel$StoreState, Unit> {
    public GuildScheduledEventListViewModel$1(GuildScheduledEventListViewModel guildScheduledEventListViewModel) {
        super(1, guildScheduledEventListViewModel, GuildScheduledEventListViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListViewModel$StoreState guildScheduledEventListViewModel$StoreState) {
        invoke2(guildScheduledEventListViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventListViewModel$StoreState guildScheduledEventListViewModel$StoreState) {
        m.checkNotNullParameter(guildScheduledEventListViewModel$StoreState, "p1");
        GuildScheduledEventListViewModel.access$handleStoreState((GuildScheduledEventListViewModel) this.receiver, guildScheduledEventListViewModel$StoreState);
    }
}
