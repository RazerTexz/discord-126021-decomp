package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.t.o;
import d0.t.u;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$init$1<T, R> implements b<Map<Long, ? extends Guild>, Set<? extends Long>> {
    public static final StoreDirectories$init$1 INSTANCE = new StoreDirectories$init$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
        return call2((Map<Long, Guild>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, Guild> map) {
        Collection<Guild> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (((Guild) t).isHub()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        return u.toSet(arrayList2);
    }
}
