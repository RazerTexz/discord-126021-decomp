package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$observeMutedGuildIds$1<T, R> implements b<Map<Long, ? extends ModelNotificationSettings>, List<? extends Long>> {
    public static final StoreUserGuildSettings$observeMutedGuildIds$1 INSTANCE = new StoreUserGuildSettings$observeMutedGuildIds$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Long> call(Map<Long, ? extends ModelNotificationSettings> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(Map<Long, ? extends ModelNotificationSettings> map) {
        Collection<? extends ModelNotificationSettings> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (((ModelNotificationSettings) t).isMuted()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((ModelNotificationSettings) it.next()).getGuildId()));
        }
        return arrayList2;
    }
}
