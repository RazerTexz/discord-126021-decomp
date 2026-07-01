package com.discord.stores;

import com.discord.models.domain.ModelApplicationStreamPreview;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$fetchStreamPreview$3 extends o implements Function1<ModelApplicationStreamPreview, Unit> {
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ StoreApplicationStreamPreviews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$fetchStreamPreview$3(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        super(1);
        this.this$0 = storeApplicationStreamPreviews;
        this.$streamKey = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStreamPreview modelApplicationStreamPreview) {
        invoke2(modelApplicationStreamPreview);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelApplicationStreamPreview modelApplicationStreamPreview) {
        m.checkNotNullParameter(modelApplicationStreamPreview, "res");
        StoreApplicationStreamPreviews.access$getDispatcher$p(this.this$0).schedule(new StoreApplicationStreamPreviews$fetchStreamPreview$3$1(this, modelApplicationStreamPreview));
    }
}
