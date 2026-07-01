package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel$1 extends o implements Function1<GuildInviteShareSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildInviteShareSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteShareSheetViewModel$1(GuildInviteShareSheetViewModel guildInviteShareSheetViewModel) {
        super(1);
        this.this$0 = guildInviteShareSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState) {
        invoke2(guildInviteShareSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInviteShareSheetViewModel$StoreState guildInviteShareSheetViewModel$StoreState) {
        m.checkNotNullParameter(guildInviteShareSheetViewModel$StoreState, "storeState");
        GuildInviteShareSheetViewModel.access$handleStoreState(this.this$0, guildInviteShareSheetViewModel$StoreState);
    }
}
