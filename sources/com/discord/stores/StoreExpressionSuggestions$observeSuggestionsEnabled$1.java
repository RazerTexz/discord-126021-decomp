package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExpressionSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionSuggestions$observeSuggestionsEnabled$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ StoreExpressionSuggestions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExpressionSuggestions$observeSuggestionsEnabled$1(StoreExpressionSuggestions storeExpressionSuggestions) {
        super(0);
        this.this$0 = storeExpressionSuggestions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StoreExpressionSuggestions.access$getSuggestionsEnabled$p(this.this$0);
    }
}
