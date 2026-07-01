package com.discord.stores;

import com.discord.models.domain.ModelGift;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$fetchMyGiftsForSku$3 extends o implements Function1<List<? extends ModelGift>, Unit> {
    public final /* synthetic */ String $comboId;
    public final /* synthetic */ Long $planId;
    public final /* synthetic */ long $skuId;
    public final /* synthetic */ StoreGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$fetchMyGiftsForSku$3(StoreGifting storeGifting, String str, long j, Long l) {
        super(1);
        this.this$0 = storeGifting;
        this.$comboId = str;
        this.$skuId = j;
        this.$planId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGift> list) {
        invoke2((List<ModelGift>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelGift> list) {
        m.checkNotNullParameter(list, "gifts");
        this.this$0.getDispatcher().schedule(new StoreGifting$fetchMyGiftsForSku$3$1(this, list));
    }
}
