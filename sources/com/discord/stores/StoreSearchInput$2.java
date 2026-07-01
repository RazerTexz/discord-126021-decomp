package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreSearchInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchInput$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ StoreSearchInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearchInput$2(StoreSearchInput storeSearchInput) {
        super(1);
        this.this$0 = storeSearchInput;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        StoreSearchInput.access$isInputValidSubject$p(this.this$0).k.onNext((T) bool);
    }
}
