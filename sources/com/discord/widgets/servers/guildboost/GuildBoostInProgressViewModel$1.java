package com.discord.widgets.servers.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost$State;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostInProgressViewModel$1<T1, T2, R> implements Func2<Guild, StoreGuildBoost$State, GuildBoostInProgressViewModel$StoreState> {
    public static final GuildBoostInProgressViewModel$1 INSTANCE = new GuildBoostInProgressViewModel$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GuildBoostInProgressViewModel$StoreState call(Guild guild, StoreGuildBoost$State storeGuildBoost$State) {
        return call2(guild, storeGuildBoost$State);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildBoostInProgressViewModel$StoreState call2(Guild guild, StoreGuildBoost$State storeGuildBoost$State) {
        m.checkNotNullExpressionValue(storeGuildBoost$State, "guildBoostState");
        return new GuildBoostInProgressViewModel$StoreState(guild, storeGuildBoost$State);
    }
}
