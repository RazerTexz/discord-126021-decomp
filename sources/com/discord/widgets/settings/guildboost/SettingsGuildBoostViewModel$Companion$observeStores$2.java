package com.discord.widgets.settings.guildboost;

import com.discord.api.premium.PremiumTier;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import java.util.Map;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGuildBoostViewModel$Companion$observeStores$2 extends C12236k implements Function4<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, Map<Long, ? extends Guild>, PremiumTier, SettingsGuildBoostViewModel.StoreState> {
    public static final SettingsGuildBoostViewModel$Companion$observeStores$2 INSTANCE = new SettingsGuildBoostViewModel$Companion$observeStores$2();

    public SettingsGuildBoostViewModel$Companion$observeStores$2() {
        super(4, SettingsGuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, ? extends Guild> map, PremiumTier premiumTier) {
        return invoke2(state, subscriptionsState, (Map<Long, Guild>) map, premiumTier);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SettingsGuildBoostViewModel.StoreState invoke2(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
        C12238m.checkNotNullParameter(state, "p1");
        C12238m.checkNotNullParameter(subscriptionsState, "p2");
        C12238m.checkNotNullParameter(map, "p3");
        C12238m.checkNotNullParameter(premiumTier, "p4");
        return new SettingsGuildBoostViewModel.StoreState(state, subscriptionsState, map, premiumTier);
    }
}
