package com.discord.stores;

import com.discord.models.gifpicker.domain.ModelGifCategory;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeGifCategories$2 extends o implements Function0<List<? extends ModelGifCategory>> {
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeGifCategories$2(StoreGifPicker storeGifPicker) {
        super(0);
        this.this$0 = storeGifPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ModelGifCategory> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ModelGifCategory> invoke2() {
        return StoreGifPicker.access$getGifCategories(this.this$0);
    }
}
