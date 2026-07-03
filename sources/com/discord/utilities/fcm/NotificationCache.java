package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import com.discord.app.AppLog;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NotificationCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCache {
    public static final NotificationCache INSTANCE = new NotificationCache();

    @SuppressLint({"StaticFieldLeak"})
    private static final Persister<HashMap<String, NotificationData.DisplayPayload>> cache = new Persister<>("NOTIFICATION_BUNDLES_V4", new HashMap());

    private NotificationCache() {
    }

    public final synchronized NotificationData.DisplayPayload get(long channelId) {
        Object next;
        NotificationData.DisplayPayload displayPayload;
        NotificationData data;
        Collection<NotificationData.DisplayPayload> collectionValues = cache.get().values();
        C12238m.checkNotNullExpressionValue(collectionValues, "cache.get().values");
        Iterator<T> it = collectionValues.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            displayPayload = (NotificationData.DisplayPayload) next;
        } while (!((displayPayload == null || (data = displayPayload.getData()) == null || data.getChannelId() != channelId) ? false : true));
        return (NotificationData.DisplayPayload) next;
    }

    public final synchronized NotificationData.DisplayPayload getAndUpdate(NotificationData data) {
        NotificationData.DisplayPayload displayPayload;
        C12238m.checkNotNullParameter(data, "data");
        Persister<HashMap<String, NotificationData.DisplayPayload>> persister = cache;
        HashMap<String, NotificationData.DisplayPayload> map = new HashMap<>(persister.get());
        displayPayload = map.get(data.getKey());
        if (displayPayload == null) {
            displayPayload = new NotificationData.DisplayPayload(data);
            map.put(data.getKey(), displayPayload);
        }
        NotificationData.DisplayPayload.update$default(displayPayload, data, 0, 2, null);
        persister.set(map, true);
        return displayPayload;
    }

    public final synchronized void remove(long channelId, boolean isAckRequest, Function1<? super Integer, Unit> notificationRemovedCallback) {
        NotificationData data;
        C12238m.checkNotNullParameter(notificationRemovedCallback, "notificationRemovedCallback");
        HashMap<String, NotificationData.DisplayPayload> map = new HashMap<>(cache.get());
        Iterator<NotificationData.DisplayPayload> it = map.values().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            NotificationData.DisplayPayload next = it.next();
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
        HashMap<String, NotificationData.DisplayPayload> map = cache.get();
        Set<Map.Entry<String, NotificationData.DisplayPayload>> setEntrySet = map.entrySet();
        C12238m.checkNotNullExpressionValue(setEntrySet, "content.entries");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (str == null) {
                str = "";
            }
            C12238m.checkNotNullExpressionValue(str, "entry.key ?: \"\"");
            NotificationData.DisplayPayload displayPayload = (NotificationData.DisplayPayload) entry.getValue();
            if (displayPayload == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("displayPayload value read from the ");
                sb.append("NOTIFICATION_BUNDLES_V4 cache ");
                sb.append("in " + INSTANCE.getClass().getSimpleName() + " is null ");
                sb.append("for channelId: " + channelId + ' ');
                StringBuilder sb2 = new StringBuilder();
                sb2.append("and notification data type: ");
                sb2.append(str);
                sb.append(sb2.toString());
                AppLog appLog = AppLog.f14950g;
                String string = sb.toString();
                C12238m.checkNotNullExpressionValue(string, "warningMessage.toString()");
                Logger.w$default(appLog, string, null, 2, null);
            }
            if (displayPayload != null) {
                arrayList.add(displayPayload);
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
            NotificationData.DisplayPayload displayPayload2 = (NotificationData.DisplayPayload) next;
            if (displayPayload2.getData().getChannelId() != channelId || displayPayload2.getIgnoreNextClearForAck() == shouldIgnoreNextClearForAck) {
                z3 = false;
            }
            if (z3) {
                arrayList2.add(next);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ((NotificationData.DisplayPayload) it3.next()).setIgnoreNextClearForAck(shouldIgnoreNextClearForAck);
            z2 = true;
        }
        cache.set(map, z2);
    }
}
