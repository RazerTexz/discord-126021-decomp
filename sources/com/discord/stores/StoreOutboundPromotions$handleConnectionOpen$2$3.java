package com.discord.stores;

import android.content.SharedPreferences$Editor;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$2$3<T> implements Action1<Long> {
    public final /* synthetic */ StoreOutboundPromotions$handleConnectionOpen$2 this$0;

    public StoreOutboundPromotions$handleConnectionOpen$2$3(StoreOutboundPromotions$handleConnectionOpen$2 storeOutboundPromotions$handleConnectionOpen$2) {
        this.this$0 = storeOutboundPromotions$handleConnectionOpen$2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Long l) {
        call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Long l) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.this$0.this$0.getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        m.checkNotNullExpressionValue(l, "consumedPromoId");
        sharedPreferences$EditorEdit.putLong("CONSUMED_ENTITLEMENT_CODE", l.longValue());
        sharedPreferences$EditorEdit.apply();
    }
}
