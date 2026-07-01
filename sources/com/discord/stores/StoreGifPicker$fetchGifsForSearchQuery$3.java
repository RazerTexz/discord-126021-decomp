package com.discord.stores;

import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$fetchGifsForSearchQuery$3 extends o implements Function1<List<? extends ModelGif>, Unit> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$fetchGifsForSearchQuery$3(StoreGifPicker storeGifPicker, String str) {
        super(1);
        this.this$0 = storeGifPicker;
        this.$query = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
        invoke2((List<ModelGif>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelGif> list) {
        StoreGifPicker.access$getDispatcher$p(this.this$0).schedule(new StoreGifPicker$fetchGifsForSearchQuery$3$1(this, list));
    }
}
