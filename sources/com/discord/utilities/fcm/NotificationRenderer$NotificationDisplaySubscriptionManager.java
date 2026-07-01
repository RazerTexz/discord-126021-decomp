package com.discord.utilities.fcm;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import java.util.HashMap;
import rx.Subscription;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer$NotificationDisplaySubscriptionManager {
    public static final NotificationRenderer$NotificationDisplaySubscriptionManager INSTANCE = new NotificationRenderer$NotificationDisplaySubscriptionManager();
    private static final HashMap<Integer, Subscription> notificationDisplaySubscriptions = new HashMap<>();

    private NotificationRenderer$NotificationDisplaySubscriptionManager() {
    }

    public final void add(int displayPayloadId, Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        HashMap<Integer, Subscription> map = notificationDisplaySubscriptions;
        synchronized (map) {
            INSTANCE.cancel(displayPayloadId);
            map.put(Integer.valueOf(displayPayloadId), subscription);
        }
    }

    public final void cancel(int displayPayloadId) {
        HashMap<Integer, Subscription> map = notificationDisplaySubscriptions;
        synchronized (map) {
            Subscription subscriptionRemove = map.remove(Integer.valueOf(displayPayloadId));
            if (subscriptionRemove != null) {
                subscriptionRemove.unsubscribe();
            }
        }
    }
}
