package com.discord.widgets.servers.guildboost;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import kotlin.jvm.functions.Function5;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildBoostViewModel$Companion$observeStores$1 extends C12236k implements Function5<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, MeUser, Guild, StoreGooglePlayPurchases.State, GuildBoostViewModel.StoreState> {
    public static final GuildBoostViewModel$Companion$observeStores$1 INSTANCE = new GuildBoostViewModel$Companion$observeStores$1();

    public GuildBoostViewModel$Companion$observeStores$1() {
        super(5, GuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public final GuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2) {
        C12238m.checkNotNullParameter(state, "p1");
        C12238m.checkNotNullParameter(subscriptionsState, "p2");
        C12238m.checkNotNullParameter(meUser, "p3");
        C12238m.checkNotNullParameter(state2, "p5");
        return new GuildBoostViewModel.StoreState(state, subscriptionsState, meUser, guild, state2);
    }
}
