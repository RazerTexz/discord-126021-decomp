package com.discord.widgets.user;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$Companion {
    private WidgetPruneUsersViewModel$Companion() {
    }

    public final Observable<WidgetPruneUsersViewModel$StoreData> observeStoreState(long guildId, ObservationDeck observationDeck, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreUser storeUsers) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUsers, "storeUsers");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storePermissions, storeGuilds, storeUsers}, false, null, null, new WidgetPruneUsersViewModel$Companion$observeStoreState$1(storePermissions, guildId, storeGuilds, storeUsers), 14, null);
    }

    public /* synthetic */ WidgetPruneUsersViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
