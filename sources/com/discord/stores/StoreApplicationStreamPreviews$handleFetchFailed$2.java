package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$handleFetchFailed$2 extends o implements Function0<Unit> {
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ StoreApplicationStreamPreviews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$handleFetchFailed$2(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        super(0);
        this.this$0 = storeApplicationStreamPreviews;
        this.$streamKey = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(this.this$0).remove(this.$streamKey);
    }
}
