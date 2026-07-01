package com.discord.stores;

import com.discord.api.presence.Presence;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$46 extends k implements Function1<List<? extends Presence>, Unit> {
    public StoreStream$initGatewaySocketListeners$46(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handlePresenceReplace", "handlePresenceReplace(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Presence> list) {
        invoke2((List<Presence>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Presence> list) {
        m.checkNotNullParameter(list, "p1");
        StoreStream.access$handlePresenceReplace((StoreStream) this.receiver, list);
    }
}
