package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$3 extends k implements Function1<String, Unit> {
    public StoreStream$deferredInit$1$3(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleFingerprint", "handleFingerprint(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        StoreStream.access$handleFingerprint((StoreStream) this.receiver, str);
    }
}
