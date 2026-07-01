package com.discord.widgets.friends;

import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$Companion {
    private FriendsListViewModel$Companion() {
    }

    public final Observable<FriendsListViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreChannelsSelected channelsSelected = storeStream$Companion.getChannelsSelected();
        StoreUserPresence presences = storeStream$Companion.getPresences();
        StoreUser users = storeStream$Companion.getUsers();
        StoreUserRelationships userRelationships = storeStream$Companion.getUserRelationships();
        StoreUserConnections userConnections = storeStream$Companion.getUserConnections();
        Observable<FriendsListViewModel$StoreState> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{storeStream$Companion.getChannelsSelected(), storeStream$Companion.getPresences(), storeStream$Companion.getUsers(), storeStream$Companion.getUserRelationships(), storeStream$Companion.getApplicationStreaming(), storeStream$Companion.getUserConnections(), storeStream$Companion.getExperiments(), storeStream$Companion.getContactSync()}, false, null, null, 14, null), 1L, TimeUnit.SECONDS).G(new FriendsListViewModel$Companion$observeStores$1(channelsSelected, presences, users, userRelationships, storeStream$Companion.getApplicationStreaming(), userConnections, storeStream$Companion.getExperiments(), storeStream$Companion.getContactSync(), storeStream$Companion.getFriendSuggestions()));
        m.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
        return observableG;
    }

    public /* synthetic */ FriendsListViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
