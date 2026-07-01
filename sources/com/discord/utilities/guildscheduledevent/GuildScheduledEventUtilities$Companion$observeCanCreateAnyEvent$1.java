package com.discord.utilities.guildscheduledevent;

import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUtilities$Companion$observeCanCreateAnyEvent$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventUtilities$Companion$observeCanCreateAnyEvent$1(long j, StoreChannels storeChannels, StorePermissions storePermissions) {
        super(0);
        this.$guildId = j;
        this.$channelsStore = storeChannels;
        this.$permissionsStore = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return GuildScheduledEventUtilities.Companion.canCreateAnyEvent(this.$guildId, this.$channelsStore, this.$permissionsStore);
    }
}
