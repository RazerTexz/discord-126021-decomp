package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.premium.OutboundPromotion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$2<T, R> implements b<List<? extends OutboundPromotion>, Observable<? extends List<? extends OutboundPromotion>>> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    public StoreOutboundPromotions$handleConnectionOpen$2(StoreOutboundPromotions storeOutboundPromotions) {
        this.this$0 = storeOutboundPromotions;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends OutboundPromotion>> call(List<? extends OutboundPromotion> list) {
        return call2((List<OutboundPromotion>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<OutboundPromotion>> call2(List<OutboundPromotion> list) {
        if (this.this$0.getPrefs().contains("CONSUMED_ENTITLEMENT_CODE")) {
            return Observable.D(new StoreOutboundPromotions$handleConnectionOpen$2$1(this, list));
        }
        m.checkNotNullExpressionValue(list, "activePromos");
        return list.isEmpty() ^ true ? ObservableExtensionsKt.restSubscribeOn$default(StoreOutboundPromotions.access$getRestAPI$p(this.this$0).getMyEntitlements(521842831262875670L, false), false, 1, null).G(StoreOutboundPromotions$handleConnectionOpen$2$2.INSTANCE).u(new StoreOutboundPromotions$handleConnectionOpen$2$3(this)).G(new StoreOutboundPromotions$handleConnectionOpen$2$4(list)) : new k(list);
    }
}
