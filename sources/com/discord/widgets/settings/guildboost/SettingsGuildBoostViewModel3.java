package com.discord.widgets.settings.guildboost;

import com.discord.api.premium.PremiumTier;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$Companion$observeStores$2, reason: use source file name */
/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGuildBoostViewModel3 extends FunctionReferenceImpl implements Function4<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, Map<Long, ? extends Guild>, PremiumTier, SettingsGuildBoostViewModel.StoreState> {
    public static final SettingsGuildBoostViewModel3 INSTANCE = new SettingsGuildBoostViewModel3();

    public SettingsGuildBoostViewModel3() {
        super(4, SettingsGuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, ? extends Guild> map, PremiumTier premiumTier) {
        return invoke2(state, subscriptionsState, (Map<Long, Guild>) map, premiumTier);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SettingsGuildBoostViewModel.StoreState invoke2(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(subscriptionsState, "p2");
        Intrinsics3.checkNotNullParameter(map, "p3");
        Intrinsics3.checkNotNullParameter(premiumTier, "p4");
        return new SettingsGuildBoostViewModel.StoreState(state, subscriptionsState, map, premiumTier);
    }
}
