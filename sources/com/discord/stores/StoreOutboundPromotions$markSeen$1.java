package com.discord.stores;

import android.content.SharedPreferences$Editor;
import com.discord.api.premium.OutboundPromotion;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$markSeen$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$markSeen$1(StoreOutboundPromotions storeOutboundPromotions) {
        super(0);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<OutboundPromotion> validActivePromotions;
        StoreOutboundPromotions$State storeOutboundPromotions$StateAccess$getState$p = StoreOutboundPromotions.access$getState$p(this.this$0);
        Object next = null;
        if (!(storeOutboundPromotions$StateAccess$getState$p instanceof StoreOutboundPromotions$State$Loaded)) {
            storeOutboundPromotions$StateAccess$getState$p = null;
        }
        StoreOutboundPromotions$State$Loaded storeOutboundPromotions$State$Loaded = (StoreOutboundPromotions$State$Loaded) storeOutboundPromotions$StateAccess$getState$p;
        if (storeOutboundPromotions$State$Loaded == null || (validActivePromotions = storeOutboundPromotions$State$Loaded.getValidActivePromotions()) == null) {
            return;
        }
        Iterator<T> it = validActivePromotions.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                UtcDateTime startDate = ((OutboundPromotion) next).getStartDate();
                do {
                    Object next2 = it.next();
                    UtcDateTime startDate2 = ((OutboundPromotion) next2).getStartDate();
                    if (startDate.compareTo(startDate2) < 0) {
                        next = next2;
                        startDate = startDate2;
                    }
                } while (it.hasNext());
            }
        }
        OutboundPromotion outboundPromotion = (OutboundPromotion) next;
        if (outboundPromotion != null) {
            SharedPreferences$Editor sharedPreferences$EditorEdit = this.this$0.getPrefs().edit();
            m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
            sharedPreferences$EditorEdit.putLong("LATEST_SEEN_PROMO_DATE", outboundPromotion.getStartDate().getDateTimeMillis());
            sharedPreferences$EditorEdit.apply();
            StoreOutboundPromotions storeOutboundPromotions = this.this$0;
            StoreOutboundPromotions.access$setState$p(storeOutboundPromotions, new StoreOutboundPromotions$State$Loaded(validActivePromotions, StoreOutboundPromotions.access$getUnseenCount(storeOutboundPromotions, validActivePromotions)));
            this.this$0.markChanged();
        }
    }
}
