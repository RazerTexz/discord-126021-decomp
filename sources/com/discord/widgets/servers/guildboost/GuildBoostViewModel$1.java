package com.discord.widgets.servers.guildboost;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostViewModel$1 extends o implements Function1<GuildBoostViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildBoostViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostViewModel$1(GuildBoostViewModel guildBoostViewModel) {
        super(1);
        this.this$0 = guildBoostViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildBoostViewModel$StoreState guildBoostViewModel$StoreState) {
        invoke2(guildBoostViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildBoostViewModel$StoreState guildBoostViewModel$StoreState) {
        m.checkNotNullParameter(guildBoostViewModel$StoreState, "storeState");
        GuildBoostViewModel.access$handleStoreState(this.this$0, guildBoostViewModel$StoreState);
    }
}
