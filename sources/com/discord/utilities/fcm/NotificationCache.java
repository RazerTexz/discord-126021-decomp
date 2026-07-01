package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCache {
    public static final NotificationCache INSTANCE = new NotificationCache();

    @SuppressLint({"StaticFieldLeak"})
    private static final Persister<HashMap<String, NotificationData$DisplayPayload>> cache = new Persister<>("NOTIFICATION_BUNDLES_V4", new HashMap());

    private NotificationCache() {
    }

    public final synchronized NotificationData$DisplayPayload get(long channelId) {
        Object next;
        NotificationData$DisplayPayload notificationData$DisplayPayload;
        NotificationData data;
        Collection<NotificationData$DisplayPayload> collectionValues = cache.get().values();
        m.checkNotNullExpressionValue(collectionValues, "cache.get().values");
        Iterator<T> it = collectionValues.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            notificationData$DisplayPayload = (NotificationData$DisplayPayload) next;
        } while (!((notificationData$DisplayPayload == null || (data = notificationData$DisplayPayload.getData()) == null || data.getChannelId() != channelId) ? false : true));
        return (NotificationData$DisplayPayload) next;
    }

    public final synchronized NotificationData$DisplayPayload getAndUpdate(NotificationData data) {
        NotificationData$DisplayPayload notificationData$DisplayPayload;
        m.checkNotNullParameter(data, "data");
        Persister<HashMap<String, NotificationData$DisplayPayload>> persister = cache;
        HashMap<String, NotificationData$DisplayPayload> map = new HashMap<>(persister.get());
        notificationData$DisplayPayload = map.get(data.getKey());
        if (notificationData$DisplayPayload == null) {
            notificationData$DisplayPayload = new NotificationData$DisplayPayload(data);
            map.put(data.getKey(), notificationData$DisplayPayload);
        }
        NotificationData$DisplayPayload.update$default(notificationData$DisplayPayload, data, 0, 2, null);
        persister.set(map, true);
        return notificationData$DisplayPayload;
    }

    public final synchronized void remove(long channelId, boolean isAckRequest, Function1<? super Integer, Unit> notificationRemovedCallback) {
        NotificationData data;
        m.checkNotNullParameter(notificationRemovedCallback, "notificationRemovedCallback");
        HashMap<String, NotificationData$DisplayPayload> map = new HashMap<>(cache.get());
        Iterator<NotificationData$DisplayPayload> it = map.values().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            NotificationData$DisplayPayload next = it.next();
            if (next != null && (data = next.getData()) != null && data.getChannelId() == channelId) {
                if (isAckRequest && next.getIgnoreNextClearForAck()) {
                    next.setIgnoreNextClearForAck(false);
                } else {
                    notificationRemovedCallback.invoke(Integer.valueOf(next.getId()));
                    it.remove();
                }
                z2 = true;
            }
        }
        cache.set(map, z2);
    }

    public final synchronized void setIgnoreNextClearForAck(long channelId, boolean shouldIgnoreNextClearForAck) {
        boolean z2;
        HashMap<String, NotificationData$DisplayPayload> map = cache.get();
        Set<Map$Entry<String, NotificationData$DisplayPayload>> setEntrySet = map.entrySet();
        m.checkNotNullExpressionValue(setEntrySet, "content.entries");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            String str = (String) map$Entry.getKey();
            if (str == null) {
                str = "";
            }
            m.checkNotNullExpressionValue(str, "entry.key ?: \"\"");
            NotificationData$DisplayPayload notificationData$DisplayPayload = (NotificationData$DisplayPayload) map$Entry.getValue();
            if (notificationData$DisplayPayload == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("displayPayload value read from the ");
                sb.append("NOTIFICATION_BUNDLES_V4 cache ");
                sb.append("in " + INSTANCE.getClass().getSimpleName() + " is null ");
                sb.append("for channelId: " + channelId + ' ');
                StringBuilder sb2 = new StringBuilder();
                sb2.append("and notification data type: ");
                sb2.append(str);
                sb.append(sb2.toString());
                AppLog appLog = AppLog.g;
                String string = sb.toString();
                m.checkNotNullExpressionValue(string, "warningMessage.toString()");
                Logger.w$default(appLog, string, null, 2, null);
            }
            if (notificationData$DisplayPayload != null) {
                arrayList.add(notificationData$DisplayPayload);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z3 = true;
            z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            NotificationData$DisplayPayload notificationData$DisplayPayload2 = (NotificationData$DisplayPayload) next;
            if (notificationData$DisplayPayload2.getData().getChannelId() != channelId || notificationData$DisplayPayload2.getIgnoreNextClearForAck() == shouldIgnoreNextClearForAck) {
                z3 = false;
            }
            if (z3) {
                arrayList2.add(next);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ((NotificationData$DisplayPayload) it3.next()).setIgnoreNextClearForAck(shouldIgnoreNextClearForAck);
            z2 = true;
        }
        cache.set(map, z2);
    }
}
