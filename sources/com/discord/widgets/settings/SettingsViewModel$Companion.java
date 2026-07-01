package com.discord.widgets.settings;

import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$Status;
import com.discord.models.domain.ModelSubscription$Type;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNotificationUpsells;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsViewModel$Companion {
    private SettingsViewModel$Companion() {
    }

    public static final /* synthetic */ boolean access$isActiveGuildSubscription$p(SettingsViewModel$Companion settingsViewModel$Companion, ModelSubscription modelSubscription) {
        return settingsViewModel$Companion.isActiveGuildSubscription(modelSubscription);
    }

    public static final /* synthetic */ Observable access$observeStoreState(SettingsViewModel$Companion settingsViewModel$Companion, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreOutboundPromotions storeOutboundPromotions, StoreNotificationUpsells storeNotificationUpsells, StoreExperiments storeExperiments, StoreSubscriptions storeSubscriptions, ObservationDeck observationDeck) {
        return settingsViewModel$Companion.observeStoreState(storeUser, storeGuilds, storeUserPresence, storeOutboundPromotions, storeNotificationUpsells, storeExperiments, storeSubscriptions, observationDeck);
    }

    private final boolean isActiveGuildSubscription(ModelSubscription modelSubscription) {
        return modelSubscription.getType() == ModelSubscription$Type.GUILD && modelSubscription.getStatus() != ModelSubscription$Status.ENDED;
    }

    private final Observable<SettingsViewModel$StoreState> observeStoreState(StoreUser userStore, StoreGuilds guildsStore, StoreUserPresence userPresenceStore, StoreOutboundPromotions outboundPromotionsStore, StoreNotificationUpsells notificationUpsellsStore, StoreExperiments experimentsStore, StoreSubscriptions subscriptionsStore, ObservationDeck observationDeck) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{userStore, guildsStore, userPresenceStore, outboundPromotionsStore, notificationUpsellsStore, subscriptionsStore}, false, null, null, new SettingsViewModel$Companion$observeStoreState$1(subscriptionsStore, userStore, guildsStore, userPresenceStore, outboundPromotionsStore, notificationUpsellsStore, experimentsStore), 14, null);
    }

    public /* synthetic */ SettingsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
