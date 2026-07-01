package com.discord.widgets.guilds.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel$1 extends o implements Function1<GuildInviteSettingsViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildInviteSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteSettingsViewModel$1(GuildInviteSettingsViewModel guildInviteSettingsViewModel) {
        super(1);
        this.this$0 = guildInviteSettingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel$StoreState guildInviteSettingsViewModel$StoreState) {
        invoke2(guildInviteSettingsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildInviteSettingsViewModel$StoreState guildInviteSettingsViewModel$StoreState) {
        m.checkNotNullParameter(guildInviteSettingsViewModel$StoreState, "storeState");
        GuildInviteSettingsViewModel.access$handleStoreState(this.this$0, guildInviteSettingsViewModel$StoreState);
    }
}
