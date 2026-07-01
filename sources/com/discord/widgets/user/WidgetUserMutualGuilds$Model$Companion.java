package com.discord.widgets.user;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Model$Companion {
    private WidgetUserMutualGuilds$Model$Companion() {
    }

    public static /* synthetic */ Observable get$default(WidgetUserMutualGuilds$Model$Companion widgetUserMutualGuilds$Model$Companion, long j, StoreUserProfile storeUserProfile, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds, int i, Object obj) {
        if ((i & 2) != 0) {
            storeUserProfile = StoreStream.Companion.getUserProfile();
        }
        StoreUserProfile storeUserProfile2 = storeUserProfile;
        if ((i & 4) != 0) {
            storeGuildsSorted = StoreStream.Companion.getGuildsSorted();
        }
        StoreGuildsSorted storeGuildsSorted2 = storeGuildsSorted;
        if ((i & 8) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 16) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        return widgetUserMutualGuilds$Model$Companion.get(j, storeUserProfile2, storeGuildsSorted2, storeUser2, storeGuilds);
    }

    public final Observable<WidgetUserMutualGuilds$Model> get(long userId, StoreUserProfile storeUserProfile, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        Observable<WidgetUserMutualGuilds$Model> observableR = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{storeUserProfile, storeGuildsSorted, storeUser, storeGuilds}, false, null, null, new WidgetUserMutualGuilds$Model$Companion$get$1(storeUserProfile, userId, storeGuildsSorted, storeUser, storeGuilds), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetUserMutualGuilds$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
