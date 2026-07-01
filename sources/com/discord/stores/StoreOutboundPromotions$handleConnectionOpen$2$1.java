package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.premium.OutboundPromotion;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$2$1<V> implements Callable<List<? extends OutboundPromotion>> {
    public final /* synthetic */ List $activePromos;
    public final /* synthetic */ StoreOutboundPromotions$handleConnectionOpen$2 this$0;

    public StoreOutboundPromotions$handleConnectionOpen$2$1(StoreOutboundPromotions$handleConnectionOpen$2 storeOutboundPromotions$handleConnectionOpen$2, List list) {
        this.this$0 = storeOutboundPromotions$handleConnectionOpen$2;
        this.$activePromos = list;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<? extends OutboundPromotion> call2() {
        long j = this.this$0.this$0.getPrefs().getLong("CONSUMED_ENTITLEMENT_CODE", -1L);
        List list = this.$activePromos;
        ArrayList arrayListA0 = a.a0(list, "activePromos");
        for (Object obj : list) {
            if (((OutboundPromotion) obj).getId() != j) {
                arrayListA0.add(obj);
            }
        }
        return arrayListA0;
    }
}
