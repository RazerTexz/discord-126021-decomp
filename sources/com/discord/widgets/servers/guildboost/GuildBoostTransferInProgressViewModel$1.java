package com.discord.widgets.servers.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost$State;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostTransferInProgressViewModel$1<T1, T2, T3, R> implements Func3<Guild, Guild, StoreGuildBoost$State, GuildBoostTransferInProgressViewModel$StoreState> {
    public static final GuildBoostTransferInProgressViewModel$1 INSTANCE = new GuildBoostTransferInProgressViewModel$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ GuildBoostTransferInProgressViewModel$StoreState call(Guild guild, Guild guild2, StoreGuildBoost$State storeGuildBoost$State) {
        return call2(guild, guild2, storeGuildBoost$State);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildBoostTransferInProgressViewModel$StoreState call2(Guild guild, Guild guild2, StoreGuildBoost$State storeGuildBoost$State) {
        m.checkNotNullExpressionValue(storeGuildBoost$State, "guildBoostState");
        return new GuildBoostTransferInProgressViewModel$StoreState(guild, guild2, storeGuildBoost$State);
    }
}
