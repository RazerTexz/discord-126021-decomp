package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$fetchStreamPreview$4 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ StoreApplicationStreamPreviews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$fetchStreamPreview$4(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        super(1);
        this.this$0 = storeApplicationStreamPreviews;
        this.$streamKey = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        StoreApplicationStreamPreviews.access$getDispatcher$p(this.this$0).schedule(new StoreApplicationStreamPreviews$fetchStreamPreview$4$1(this, error));
    }
}
