package com.discord.stores;

import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeSearchHistory$1 extends o implements Function0<Map<String, ? extends List<? extends ModelGif>>> {
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeSearchHistory$1(StoreGifPicker storeGifPicker) {
        super(0);
        this.this$0 = storeGifPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends ModelGif>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends List<? extends ModelGif>> invoke2() {
        return StoreGifPicker.access$getSearchHistory(this.this$0);
    }
}
