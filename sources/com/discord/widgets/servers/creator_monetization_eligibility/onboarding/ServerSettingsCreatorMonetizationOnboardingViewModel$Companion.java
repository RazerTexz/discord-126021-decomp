package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$Companion {
    private ServerSettingsCreatorMonetizationOnboardingViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(ServerSettingsCreatorMonetizationOnboardingViewModel$Companion serverSettingsCreatorMonetizationOnboardingViewModel$Companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreUser storeUser, long j) {
        return serverSettingsCreatorMonetizationOnboardingViewModel$Companion.observeStores(observationDeck, storeGuilds, storeUser, j);
    }

    private final Observable<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState> observeStores(ObservationDeck observationDeck, StoreGuilds guilds, StoreUser users, long guildId) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{guilds, users}, false, null, null, new ServerSettingsCreatorMonetizationOnboardingViewModel$Companion$observeStores$1(guilds, guildId, users), 14, null);
    }

    public /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
