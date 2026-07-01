package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$fetchSuggestedSearchTerms$2 extends o implements Function1<List<? extends String>, Unit> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$fetchSuggestedSearchTerms$2(StoreGifPicker storeGifPicker, String str) {
        super(1);
        this.this$0 = storeGifPicker;
        this.$query = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
        invoke2((List<String>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<String> list) {
        m.checkNotNullParameter(list, "suggestedSearchTerms");
        StoreGifPicker.access$getDispatcher$p(this.this$0).schedule(new StoreGifPicker$fetchSuggestedSearchTerms$2$1(this, list));
    }
}
