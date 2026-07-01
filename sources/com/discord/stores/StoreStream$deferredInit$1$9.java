package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$deferredInit$1$9 extends k implements Function1<List<? extends StoreRtcConnection$SpeakingUserUpdate>, Unit> {
    public StoreStream$deferredInit$1$9(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleSpeakingUpdates", "handleSpeakingUpdates(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreRtcConnection$SpeakingUserUpdate> list) {
        invoke2((List<StoreRtcConnection$SpeakingUserUpdate>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<StoreRtcConnection$SpeakingUserUpdate> list) {
        m.checkNotNullParameter(list, "p1");
        StoreStream.access$handleSpeakingUpdates((StoreStream) this.receiver, list);
    }
}
