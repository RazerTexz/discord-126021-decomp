package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$fetchStreamPreview$4$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ StoreApplicationStreamPreviews$fetchStreamPreview$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$fetchStreamPreview$4$1(StoreApplicationStreamPreviews$fetchStreamPreview$4 storeApplicationStreamPreviews$fetchStreamPreview$4, Error error) {
        super(0);
        this.this$0 = storeApplicationStreamPreviews$fetchStreamPreview$4;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationStreamPreviews$fetchStreamPreview$4 storeApplicationStreamPreviews$fetchStreamPreview$4 = this.this$0;
        storeApplicationStreamPreviews$fetchStreamPreview$4.this$0.handleFetchFailed(storeApplicationStreamPreviews$fetchStreamPreview$4.$streamKey, this.$error);
    }
}
