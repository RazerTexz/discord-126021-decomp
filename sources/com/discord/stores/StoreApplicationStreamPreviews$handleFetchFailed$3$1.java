package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$handleFetchFailed$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreApplicationStreamPreviews$handleFetchFailed$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$handleFetchFailed$3$1(StoreApplicationStreamPreviews$handleFetchFailed$3 storeApplicationStreamPreviews$handleFetchFailed$3) {
        super(0);
        this.this$0 = storeApplicationStreamPreviews$handleFetchFailed$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationStreamPreviews$handleFetchFailed$3 storeApplicationStreamPreviews$handleFetchFailed$3 = this.this$0;
        StoreApplicationStreamPreviews.access$fetchStreamPreviewIfNotFetching(storeApplicationStreamPreviews$handleFetchFailed$3.this$0, storeApplicationStreamPreviews$handleFetchFailed$3.$streamKey);
    }
}
