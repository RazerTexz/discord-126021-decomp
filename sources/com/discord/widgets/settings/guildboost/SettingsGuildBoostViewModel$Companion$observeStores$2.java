package com.discord.widgets.settings.guildboost;

import com.discord.api.premium.PremiumTier;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGuildBoostViewModel$Companion$observeStores$2 extends k implements Function4<StoreGuildBoost$State, StoreSubscriptions$SubscriptionsState, Map<Long, ? extends Guild>, PremiumTier, SettingsGuildBoostViewModel$StoreState> {
    public static final SettingsGuildBoostViewModel$Companion$observeStores$2 INSTANCE = new SettingsGuildBoostViewModel$Companion$observeStores$2();

    public SettingsGuildBoostViewModel$Companion$observeStores$2() {
        super(4, SettingsGuildBoostViewModel$StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGuildBoostViewModel$StoreState invoke(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, Map<Long, ? extends Guild> map, PremiumTier premiumTier) {
        return invoke2(storeGuildBoost$State, storeSubscriptions$SubscriptionsState, (Map<Long, Guild>) map, premiumTier);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SettingsGuildBoostViewModel$StoreState invoke2(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
        m.checkNotNullParameter(storeGuildBoost$State, "p1");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "p2");
        m.checkNotNullParameter(map, "p3");
        m.checkNotNullParameter(premiumTier, "p4");
        return new SettingsGuildBoostViewModel$StoreState(storeGuildBoost$State, storeSubscriptions$SubscriptionsState, map, premiumTier);
    }
}
