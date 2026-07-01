package com.discord.widgets.friends;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import java.util.Collection;
import rx.Observable;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$ModelProvider {
    public static final WidgetFriendsFindNearby$ModelProvider INSTANCE = new WidgetFriendsFindNearby$ModelProvider();

    private WidgetFriendsFindNearby$ModelProvider() {
    }

    public static final /* synthetic */ Observable access$getUserModels(WidgetFriendsFindNearby$ModelProvider widgetFriendsFindNearby$ModelProvider, Collection collection) {
        return widgetFriendsFindNearby$ModelProvider.getUserModels(collection);
    }

    private final Observable<WidgetFriendsFindNearby$Model$NearbyUsers> getUserModels(Collection<Long> userIds) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetFriendsFindNearby$Model$NearbyUsers> observableI = Observable.i(storeStream$Companion.getUsers().observeUsers(userIds, true), storeStream$Companion.getPresences().observePresencesForUsers(userIds), storeStream$Companion.getUserRelationships().observe(userIds), WidgetFriendsFindNearby$ModelProvider$getUserModels$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable\n          .co…yUsers(items)\n          }");
        return observableI;
    }

    public final Observable<WidgetFriendsFindNearby$Model> get(Observable<NearbyManager$NearbyState> nearbyStateObservable) {
        m.checkNotNullParameter(nearbyStateObservable, "nearbyStateObservable");
        Observable observableY = nearbyStateObservable.Y(WidgetFriendsFindNearby$ModelProvider$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "nearbyStateObservable\n  …          }\n            }");
        return observableY;
    }
}
