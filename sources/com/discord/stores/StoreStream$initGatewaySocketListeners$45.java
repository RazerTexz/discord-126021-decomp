package com.discord.stores;

import com.discord.api.presence.Presence;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$initGatewaySocketListeners$45 extends o implements Function1<Presence, Unit> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$initGatewaySocketListeners$45(StoreStream storeStream) {
        super(1);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Presence presence) {
        invoke2(presence);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Presence presence) {
        StoreStream storeStream = this.this$0;
        Long guildId = presence.getGuildId();
        long jLongValue = guildId != null ? guildId.longValue() : 0L;
        m.checkNotNullExpressionValue(presence, "it");
        StoreStream.access$handlePresenceUpdate(storeStream, jLongValue, presence);
    }
}
