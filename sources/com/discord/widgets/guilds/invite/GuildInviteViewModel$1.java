package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel$1 extends o implements Function1<GuildInviteViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildInviteViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel$1(GuildInviteViewModel guildInviteViewModel) {
        super(1);
        this.this$0 = guildInviteViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInviteViewModel$StoreState guildInviteViewModel$StoreState) {
        invoke2(guildInviteViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInviteViewModel$StoreState guildInviteViewModel$StoreState) {
        m.checkNotNullParameter(guildInviteViewModel$StoreState, "storeState");
        GuildInviteViewModel.access$handleStoreState(this.this$0, guildInviteViewModel$StoreState);
    }
}
