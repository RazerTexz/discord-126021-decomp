package com.discord.gateway;

import com.discord.utilities.rest.SendUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$close$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $clean;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$close$1(GatewaySocket gatewaySocket, boolean z2) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$clean = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (GatewaySocket.access$getConnectionState$p(this.this$0) == 0) {
            return;
        }
        int i = this.$clean ? 1000 : SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM;
        GatewaySocket.access$cleanup(this.this$0, new GatewaySocket$close$1$1(i));
        GatewaySocket.access$setConnectionState$p(this.this$0, 0);
        GatewaySocket.access$reset(this.this$0, this.$clean, i, "Disconnect requested by client");
    }
}
