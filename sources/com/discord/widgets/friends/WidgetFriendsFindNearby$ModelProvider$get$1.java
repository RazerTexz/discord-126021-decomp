package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import j0.l.e.k;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$ModelProvider$get$1<T, R> implements b<NearbyManager$NearbyState, Observable<? extends WidgetFriendsFindNearby$Model>> {
    public static final WidgetFriendsFindNearby$ModelProvider$get$1 INSTANCE = new WidgetFriendsFindNearby$ModelProvider$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetFriendsFindNearby$Model> call(NearbyManager$NearbyState nearbyManager$NearbyState) {
        return call2(nearbyManager$NearbyState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetFriendsFindNearby$Model> call2(NearbyManager$NearbyState nearbyManager$NearbyState) {
        k kVar;
        if (nearbyManager$NearbyState instanceof NearbyManager$NearbyState$Disconnected) {
            return new k(new WidgetFriendsFindNearby$Model$Error(Integer.valueOf(((NearbyManager$NearbyState$Disconnected) nearbyManager$NearbyState).getCode())));
        }
        if (nearbyManager$NearbyState instanceof NearbyManager$NearbyState$Uninitialized) {
            kVar = new k(WidgetFriendsFindNearby$Model$Uninitialized.INSTANCE);
        } else {
            if (!(nearbyManager$NearbyState instanceof NearbyManager$NearbyState$Connected)) {
                throw new NoWhenBranchMatchedException();
            }
            NearbyManager$NearbyState$Connected nearbyManager$NearbyState$Connected = (NearbyManager$NearbyState$Connected) nearbyManager$NearbyState;
            if (!nearbyManager$NearbyState$Connected.getNearbyUserIds().isEmpty()) {
                return WidgetFriendsFindNearby$ModelProvider.access$getUserModels(WidgetFriendsFindNearby$ModelProvider.INSTANCE, nearbyManager$NearbyState$Connected.getNearbyUserIds());
            }
            kVar = new k(WidgetFriendsFindNearby$Model$Empty.INSTANCE);
        }
        return kVar;
    }
}
