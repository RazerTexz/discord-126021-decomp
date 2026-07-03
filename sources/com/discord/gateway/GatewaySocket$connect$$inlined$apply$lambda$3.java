package com.discord.gateway;

import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$3 extends AbstractC12240o implements Function2<InputStreamReader, Integer, Unit> {
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
        return Unit.f27425a;
    }

    public final void invoke(InputStreamReader inputStreamReader, int i) {
        C12238m.checkNotNullParameter(inputStreamReader, "reader");
        this.this$0.handleWebSocketMessage(inputStreamReader, i);
    }
}
