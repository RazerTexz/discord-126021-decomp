package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.premium.OutboundPromotion;
import j0.k.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$2$4<T, R> implements b<Long, List<? extends OutboundPromotion>> {
    public final /* synthetic */ List $activePromos;

    public StoreOutboundPromotions$handleConnectionOpen$2$4(List list) {
        this.$activePromos = list;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<OutboundPromotion> call2(Long l) {
        List list = this.$activePromos;
        ArrayList arrayListA0 = a.a0(list, "activePromos");
        for (T t : list) {
            if (l == null || ((OutboundPromotion) t).getId() != l.longValue()) {
                arrayListA0.add(t);
            }
        }
        return arrayListA0;
    }
}
