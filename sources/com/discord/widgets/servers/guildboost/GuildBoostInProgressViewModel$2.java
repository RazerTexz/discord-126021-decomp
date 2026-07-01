package com.discord.widgets.servers.guildboost;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostInProgressViewModel$2 extends o implements Function1<GuildBoostInProgressViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildBoostInProgressViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel$2(GuildBoostInProgressViewModel guildBoostInProgressViewModel) {
        super(1);
        this.this$0 = guildBoostInProgressViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildBoostInProgressViewModel$StoreState guildBoostInProgressViewModel$StoreState) {
        invoke2(guildBoostInProgressViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildBoostInProgressViewModel$StoreState guildBoostInProgressViewModel$StoreState) {
        m.checkNotNullParameter(guildBoostInProgressViewModel$StoreState, "storeState");
        GuildBoostInProgressViewModel.access$handleStoreState(this.this$0, guildBoostInProgressViewModel$StoreState);
    }
}
