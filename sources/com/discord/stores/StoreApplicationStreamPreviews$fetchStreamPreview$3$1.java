package com.discord.stores;

import com.discord.models.domain.ModelApplicationStreamPreview;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$fetchStreamPreview$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelApplicationStreamPreview $res;
    public final /* synthetic */ StoreApplicationStreamPreviews$fetchStreamPreview$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$fetchStreamPreview$3$1(StoreApplicationStreamPreviews$fetchStreamPreview$3 storeApplicationStreamPreviews$fetchStreamPreview$3, ModelApplicationStreamPreview modelApplicationStreamPreview) {
        super(0);
        this.this$0 = storeApplicationStreamPreviews$fetchStreamPreview$3;
        this.$res = modelApplicationStreamPreview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationStreamPreviews$fetchStreamPreview$3 storeApplicationStreamPreviews$fetchStreamPreview$3 = this.this$0;
        storeApplicationStreamPreviews$fetchStreamPreview$3.this$0.handleFetchSuccess(storeApplicationStreamPreviews$fetchStreamPreview$3.$streamKey, this.$res.getUrl());
    }
}
