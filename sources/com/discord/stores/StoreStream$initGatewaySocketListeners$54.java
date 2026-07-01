package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$54 extends k implements Function1<ModelGuildMemberListUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$54(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildMemberListUpdate", "handleGuildMemberListUpdate(Lcom/discord/models/domain/ModelGuildMemberListUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
        invoke2(modelGuildMemberListUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
        m.checkNotNullParameter(modelGuildMemberListUpdate, "p1");
        StoreStream.access$handleGuildMemberListUpdate((StoreStream) this.receiver, modelGuildMemberListUpdate);
    }
}
