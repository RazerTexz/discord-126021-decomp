package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeSuggestedSearchTerms$1 extends o implements Function0<Map<String, ? extends List<? extends String>>> {
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeSuggestedSearchTerms$1(StoreGifPicker storeGifPicker) {
        super(0);
        this.this$0 = storeGifPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends String>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends List<? extends String>> invoke2() {
        return StoreGifPicker.access$getSuggestedSearchTermsHistory(this.this$0);
    }
}
