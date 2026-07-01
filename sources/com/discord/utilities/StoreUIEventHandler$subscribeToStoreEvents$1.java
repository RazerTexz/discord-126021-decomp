package com.discord.utilities;

import com.discord.rtcconnection.KrispOveruseDetector$Status;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUIEventHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUIEventHandler$subscribeToStoreEvents$1 extends o implements Function1<KrispOveruseDetector$Status, Unit> {
    public final /* synthetic */ StoreUIEventHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUIEventHandler$subscribeToStoreEvents$1(StoreUIEventHandler storeUIEventHandler) {
        super(1);
        this.this$0 = storeUIEventHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(KrispOveruseDetector$Status krispOveruseDetector$Status) {
        invoke2(krispOveruseDetector$Status);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(KrispOveruseDetector$Status krispOveruseDetector$Status) {
        m.checkNotNullParameter(krispOveruseDetector$Status, "it");
        StoreUIEventHandler.access$handleKrispStatusEvent(this.this$0, krispOveruseDetector$Status);
    }
}
