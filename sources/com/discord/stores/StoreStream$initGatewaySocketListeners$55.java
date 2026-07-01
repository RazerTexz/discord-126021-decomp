package com.discord.stores;

import com.discord.models.domain.ModelSession;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$55 extends k implements Function1<List<? extends ModelSession>, Unit> {
    public StoreStream$initGatewaySocketListeners$55(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleSessionsReplace", "handleSessionsReplace(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelSession> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ModelSession> list) {
        m.checkNotNullParameter(list, "p1");
        StoreStream.access$handleSessionsReplace((StoreStream) this.receiver, list);
    }
}
