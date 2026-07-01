package com.discord.widgets.servers.guildboost;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildBoostViewModel$Companion$observeStores$1 extends k implements Function5<StoreGuildBoost$State, StoreSubscriptions$SubscriptionsState, MeUser, Guild, StoreGooglePlayPurchases$State, GuildBoostViewModel$StoreState> {
    public static final GuildBoostViewModel$Companion$observeStores$1 INSTANCE = new GuildBoostViewModel$Companion$observeStores$1();

    public GuildBoostViewModel$Companion$observeStores$1() {
        super(5, GuildBoostViewModel$StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ GuildBoostViewModel$StoreState invoke(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        return invoke2(storeGuildBoost$State, storeSubscriptions$SubscriptionsState, meUser, guild, storeGooglePlayPurchases$State);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildBoostViewModel$StoreState invoke2(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        m.checkNotNullParameter(storeGuildBoost$State, "p1");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "p2");
        m.checkNotNullParameter(meUser, "p3");
        m.checkNotNullParameter(storeGooglePlayPurchases$State, "p5");
        return new GuildBoostViewModel$StoreState(storeGuildBoost$State, storeSubscriptions$SubscriptionsState, meUser, guild, storeGooglePlayPurchases$State);
    }
}
