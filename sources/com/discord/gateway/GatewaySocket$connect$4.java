package com.discord.gateway;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GatewaySocket$connect$4 extends k implements Function3<String, Exception, Map<String, ? extends String>, Unit> {
    public GatewaySocket$connect$4(GatewaySocket gatewaySocket) {
        super(3, gatewaySocket, GatewaySocket.class, "logError", "logError(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Exception exc, Map<String, ? extends String> map) {
        invoke2(str, exc, (Map<String, String>) map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Exception exc, Map<String, String> map) {
        m.checkNotNullParameter(str, "p1");
        m.checkNotNullParameter(exc, "p2");
        GatewaySocket.access$logError((GatewaySocket) this.receiver, str, exc, map);
    }
}
