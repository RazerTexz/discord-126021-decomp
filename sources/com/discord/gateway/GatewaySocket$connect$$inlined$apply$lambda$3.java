package com.discord.gateway;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$3 extends Lambda implements Function2<InputStreamReader, Integer, Unit> {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$connect$$inlined$apply$lambda$3(GatewaySocket gatewaySocket, String str) {
        super(2);
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
        invoke(inputStreamReader, num.intValue());
        return Unit.a;
    }

    public final void invoke(InputStreamReader inputStreamReader, int i) {
        Intrinsics3.checkNotNullParameter(inputStreamReader, "reader");
        this.this$0.handleWebSocketMessage(inputStreamReader, i);
    }
}
