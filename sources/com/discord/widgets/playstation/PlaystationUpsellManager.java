package com.discord.widgets.playstation;

import android.content.SharedPreferences;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.user.User;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PlaystationUpsellManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlaystationUpsellManager {
    private static final String SHOWN_CACHE_KEY = "HAS_PLAYSTATION_UPSELL_BEEN_SHOWN";
    private final Clock clock;
    private final StoreExperiments experimentStore;
    private final SharedPreferences sharedPreferences;

    public PlaystationUpsellManager(SharedPreferences sharedPreferences, StoreExperiments storeExperiments, Clock clock) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.sharedPreferences = sharedPreferences;
        this.experimentStore = storeExperiments;
        this.clock = clock;
    }

    private final boolean hasBeenShown() {
        return this.sharedPreferences.getBoolean(SHOWN_CACHE_KEY, false);
    }

    private final boolean isAccountOldEnough(User user) {
        return UserUtils.INSTANCE.getAgeMs(user, this.clock) > 604800000;
    }

    private final boolean isUserMissingPlaystationAccountIntegration(StoreUserConnections.State connectedAccountsState) {
        boolean z2;
        if (!Intrinsics3.areEqual(connectedAccountsState, StoreUserConnections.State.Loading.INSTANCE)) {
            if ((connectedAccountsState instanceof Collection) && connectedAccountsState.isEmpty()) {
                z2 = true;
            } else {
                Iterator<ConnectedAccount> it = connectedAccountsState.iterator();
                while (it.hasNext()) {
                    if (Platform.INSTANCE.from(it.next()) == Platform.PLAYSTATION) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean canShow(User user, StoreUserConnections.State connectedAccountsState) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(connectedAccountsState, "connectedAccountsState");
        return isAccountOldEnough(user) && isUserMissingPlaystationAccountIntegration(connectedAccountsState) && !hasBeenShown() && PlaystationExperimentUtils.canSeePlaystationUpsells(this.experimentStore);
    }

    public final void setHasBeenShown() {
        this.sharedPreferences.edit().putBoolean(SHOWN_CACHE_KEY, true).apply();
    }
}
