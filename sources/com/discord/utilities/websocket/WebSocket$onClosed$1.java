package com.discord.utilities.websocket;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$onClosed$1 extends o implements Function1<WebSocket$Closed, Unit> {
    public static final WebSocket$onClosed$1 INSTANCE = new WebSocket$onClosed$1();

    public WebSocket$onClosed$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket$Closed webSocket$Closed) {
        invoke2(webSocket$Closed);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket$Closed webSocket$Closed) {
        m.checkNotNullParameter(webSocket$Closed, "it");
    }
}
