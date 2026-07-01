package com.discord.widgets.settings;

import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNotificationUpsells;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsViewModel$Companion$observeStoreState$1 extends o implements Function0<SettingsViewModel$StoreState> {
    public final /* synthetic */ StoreExperiments $experimentsStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreNotificationUpsells $notificationUpsellsStore;
    public final /* synthetic */ StoreOutboundPromotions $outboundPromotionsStore;
    public final /* synthetic */ StoreSubscriptions $subscriptionsStore;
    public final /* synthetic */ StoreUserPresence $userPresenceStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$Companion$observeStoreState$1(StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreOutboundPromotions storeOutboundPromotions, StoreNotificationUpsells storeNotificationUpsells, StoreExperiments storeExperiments) {
        super(0);
        this.$subscriptionsStore = storeSubscriptions;
        this.$userStore = storeUser;
        this.$guildsStore = storeGuilds;
        this.$userPresenceStore = storeUserPresence;
        this.$outboundPromotionsStore = storeOutboundPromotions;
        this.$notificationUpsellsStore = storeNotificationUpsells;
        this.$experimentsStore = storeExperiments;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SettingsViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsViewModel$StoreState invoke() {
        StoreSubscriptions$SubscriptionsState subscriptionsStateSnapshot = this.$subscriptionsStore.getSubscriptionsStateSnapshot();
        if (!(subscriptionsStateSnapshot instanceof StoreSubscriptions$SubscriptionsState$Loaded)) {
            subscriptionsStateSnapshot = null;
        }
        StoreSubscriptions$SubscriptionsState$Loaded storeSubscriptions$SubscriptionsState$Loaded = (StoreSubscriptions$SubscriptionsState$Loaded) subscriptionsStateSnapshot;
        return new SettingsViewModel$StoreState(this.$userStore.getMeSnapshot(), StoreExperiments.Companion.isExperimentalAlpha(this.$guildsStore, this.$userStore), this.$userPresenceStore.getLocalPresenceSnapshot(), this.$outboundPromotionsStore.getUnseenCount(), this.$notificationUpsellsStore.getPushNotificationsUpsellDismissed(), GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().canUserAccessRoleSubscriptionManagement(this.$experimentsStore), storeSubscriptions$SubscriptionsState$Loaded != null ? storeSubscriptions$SubscriptionsState$Loaded.getSubscriptions() : null);
    }
}
