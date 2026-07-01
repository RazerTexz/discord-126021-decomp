package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Random;
import java.util.Set;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationData$DisplayPayload {
    private NotificationData data;
    private final LinkedHashMap<Long, NotificationData> extras;
    private final int id;
    private boolean ignoreNextClearForAck;

    public NotificationData$DisplayPayload(NotificationData notificationData) {
        m.checkNotNullParameter(notificationData, "data");
        this.data = notificationData;
        this.id = new Random().nextInt(Integer.MAX_VALUE);
        this.extras = new LinkedHashMap<>();
    }

    private final void trimExtrasWhenOversized(int maxExtras) {
        if (this.extras.size() < maxExtras) {
            return;
        }
        Set<Map$Entry<Long, NotificationData>> setEntrySet = this.extras.entrySet();
        m.checkNotNullExpressionValue(setEntrySet, "extras\n          .entries");
        List<Map$Entry> listDrop = u.drop(setEntrySet, this.extras.size() - (maxExtras / 2));
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(listDrop, 10)), 16));
        for (Map$Entry map$Entry : listDrop) {
            linkedHashMap.put((Long) map$Entry.getKey(), (NotificationData) map$Entry.getValue());
        }
        this.extras.clear();
        this.extras.putAll(linkedHashMap);
    }

    public static /* synthetic */ void update$default(NotificationData$DisplayPayload notificationData$DisplayPayload, NotificationData notificationData, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        notificationData$DisplayPayload.update(notificationData, i);
    }

    public final NotificationData getData() {
        return this.data;
    }

    public final synchronized List<NotificationData> getExtras() {
        Collection<NotificationData> collectionValues;
        collectionValues = this.extras.values();
        m.checkNotNullExpressionValue(collectionValues, "extras.values");
        return u.toList(collectionValues);
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getIgnoreNextClearForAck() {
        return this.ignoreNextClearForAck;
    }

    public final void setData(NotificationData notificationData) {
        m.checkNotNullParameter(notificationData, "<set-?>");
        this.data = notificationData;
    }

    public final void setIgnoreNextClearForAck(boolean z2) {
        this.ignoreNextClearForAck = z2;
    }

    public final synchronized void update(NotificationData data, int maxExtras) {
        m.checkNotNullParameter(data, "data");
        this.data = data;
        trimExtrasWhenOversized(maxExtras);
        if (data.getShouldGroup()) {
            this.extras.put(Long.valueOf(data.getMessageId()), data);
        } else {
            this.extras.clear();
        }
    }

    public NotificationData$DisplayPayload() {
        this(new NotificationData());
    }
}
