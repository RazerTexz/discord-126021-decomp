package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserAffinity;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities$observeAffinityUserIds$1<T, R> implements b<ModelUserAffinities, List<? extends Long>> {
    public static final StoreUserAffinities$observeAffinityUserIds$1 INSTANCE = new StoreUserAffinities$observeAffinityUserIds$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Long> call(ModelUserAffinities modelUserAffinities) {
        return call2(modelUserAffinities);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(ModelUserAffinities modelUserAffinities) {
        List<ModelUserAffinity> userAffinities = modelUserAffinities.getUserAffinities();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(userAffinities, 10));
        Iterator<T> it = userAffinities.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelUserAffinity) it.next()).getUserId()));
        }
        return arrayList;
    }
}
