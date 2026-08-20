package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel$Companion$observeStores$1 extends AbstractC12240o implements Function0<DisableGuildCommunicationViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel$Companion$observeStores$1(StoreUser storeUser, long j, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$userStore = storeUser;
        this.$userId = j;
        this.$guildsStore = storeGuilds;
        this.$guildId = j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisableGuildCommunicationViewModel.StoreState invoke() {
        return new DisableGuildCommunicationViewModel.StoreState(this.$userStore.getUsers().get(Long.valueOf(this.$userId)), this.$guildsStore.getGuild(this.$guildId));
    }
}
