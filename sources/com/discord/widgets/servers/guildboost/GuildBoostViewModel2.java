package com.discord.widgets.servers.guildboost;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.servers.guildboost.GuildBoostViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function5;

/* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildBoostViewModel2 extends FunctionReferenceImpl implements Function5<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, MeUser, Guild, StoreGooglePlayPurchases.State, GuildBoostViewModel.StoreState> {
    public static final GuildBoostViewModel2 INSTANCE = new GuildBoostViewModel2();

    public GuildBoostViewModel2() {
        super(5, GuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public final GuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(subscriptionsState, "p2");
        Intrinsics3.checkNotNullParameter(meUser, "p3");
        Intrinsics3.checkNotNullParameter(state2, "p5");
        return new GuildBoostViewModel.StoreState(state, subscriptionsState, meUser, guild, state2);
    }
}
