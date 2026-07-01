package com.discord.utilities.fcm;

import android.content.Intent;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationData$Companion {
    private NotificationData$Companion() {
    }

    public static final /* synthetic */ List access$parseAckChannelIds(NotificationData$Companion notificationData$Companion, String str) {
        return notificationData$Companion.parseAckChannelIds(str);
    }

    private final void copyIntIntoMap(Intent intent, Map<String, Object> map, String str) {
        int intExtra = intent != null ? intent.getIntExtra(str, -1) : -1;
        if (intExtra < 0) {
            return;
        }
        map.put(str, Integer.valueOf(intExtra));
    }

    private final void copyLongIntoMap(Intent intent, Map<String, Object> map, String str) {
        long longExtra = intent != null ? intent.getLongExtra(str, -1L) : -1L;
        if (longExtra < 0) {
            return;
        }
        map.put(str, Long.valueOf(longExtra));
    }

    private final void copyStringIntoMap(Intent intent, Map<String, Object> map, String str) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(str)) == null) {
            return;
        }
        m.checkNotNullExpressionValue(stringExtra, "this?.getStringExtra(key) ?: return");
        if (stringExtra.length() == 0) {
            return;
        }
        map.put(str, stringExtra);
    }

    private final List<Long> parseAckChannelIds(String longStringsConcatenated) {
        if (longStringsConcatenated == null) {
            longStringsConcatenated = "";
        }
        List listSplit$default = w.split$default((CharSequence) longStringsConcatenated, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (true) {
            long jLongValue = -1;
            if (!it.hasNext()) {
                break;
            }
            Long longOrNull = s.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                jLongValue = longOrNull.longValue();
            }
            arrayList.add(Long.valueOf(jLongValue));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) obj).longValue() != -1) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final Map<String, Object> buildTrackingData(Intent intent) {
        String stringExtra;
        HashMap map = new HashMap();
        copyStringIntoMap(intent, map, "notif_type");
        copyLongIntoMap(intent, map, "notif_user_id");
        copyLongIntoMap(intent, map, "message_id");
        copyLongIntoMap(intent, map, ModelAuditLogEntry.CHANGE_KEY_GUILD_ID);
        copyLongIntoMap(intent, map, ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
        copyIntIntoMap(intent, map, "message_type");
        copyIntIntoMap(intent, map, "channel_type");
        copyIntIntoMap(intent, map, "rel_type");
        copyIntIntoMap(intent, map, "activity_type");
        copyStringIntoMap(intent, map, "activity_name");
        if (intent != null && (stringExtra = intent.getStringExtra("com.discord.intent.ORIGIN_SOURCE")) != null) {
            map.put("notif_in_app", Boolean.valueOf(t.equals(stringExtra, "com.discord.intent.ORIGIN_NOTIF_INAPP", true)));
        }
        return map;
    }

    public /* synthetic */ NotificationData$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
