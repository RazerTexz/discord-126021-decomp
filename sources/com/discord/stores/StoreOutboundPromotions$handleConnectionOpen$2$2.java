package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelEntitlement;
import d0.z.d.m;
import j0.k.b;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$2$2<T, R> implements b<List<? extends ModelEntitlement>, Long> {
    public static final StoreOutboundPromotions$handleConnectionOpen$2$2 INSTANCE = new StoreOutboundPromotions$handleConnectionOpen$2$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(List<? extends ModelEntitlement> list) {
        return call2((List<ModelEntitlement>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(List<ModelEntitlement> list) {
        T next;
        Long promotionId;
        ModelEntitlement modelEntitlement;
        m.checkNotNullExpressionValue(list, "entitlements");
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            modelEntitlement = (ModelEntitlement) next;
        } while (!(m.areEqual(modelEntitlement.getConsumed(), Boolean.TRUE) && modelEntitlement.getPromotionId() != null));
        ModelEntitlement modelEntitlement2 = next;
        return Long.valueOf((modelEntitlement2 == null || (promotionId = modelEntitlement2.getPromotionId()) == null) ? -1L : promotionId.longValue());
    }
}
