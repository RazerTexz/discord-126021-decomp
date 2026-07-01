package com.discord.widgets.settings;

import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNotificationUpsells;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.settings.SettingsViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.SettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsViewModel2 extends Lambda implements Function0<SettingsViewModel.StoreState> {
    public final /* synthetic */ StoreExperiments $experimentsStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreNotificationUpsells $notificationUpsellsStore;
    public final /* synthetic */ StoreOutboundPromotions $outboundPromotionsStore;
    public final /* synthetic */ StoreSubscriptions $subscriptionsStore;
    public final /* synthetic */ StoreUserPresence $userPresenceStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel2(StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreOutboundPromotions storeOutboundPromotions, StoreNotificationUpsells storeNotificationUpsells, StoreExperiments storeExperiments) {
        super(0);
        this.$subscriptionsStore = storeSubscriptions;
        this.$userStore = storeUser;
        this.$guildsStore = storeGuilds;
        this.$userPresenceStore = storeUserPresence;
        this.$outboundPromotionsStore = storeOutboundPromotions;
        this.$notificationUpsellsStore = storeNotificationUpsells;
        this.$experimentsStore = storeExperiments;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsViewModel.StoreState invoke() {
        StoreSubscriptions.SubscriptionsState subscriptionsStateSnapshot = this.$subscriptionsStore.getSubscriptionsStateSnapshot();
        if (!(subscriptionsStateSnapshot instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            subscriptionsStateSnapshot = null;
        }
        StoreSubscriptions.SubscriptionsState.Loaded loaded = (StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsStateSnapshot;
        return new SettingsViewModel.StoreState(this.$userStore.getMeSnapshot(), StoreExperiments.INSTANCE.isExperimentalAlpha(this.$guildsStore, this.$userStore), this.$userPresenceStore.getLocalPresenceSnapshot(), this.$outboundPromotionsStore.getUnseenCount(), this.$notificationUpsellsStore.getPushNotificationsUpsellDismissed(), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canUserAccessRoleSubscriptionManagement(this.$experimentsStore), loaded != null ? loaded.getSubscriptions() : null);
    }
}
