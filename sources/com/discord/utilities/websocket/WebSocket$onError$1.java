package com.discord.utilities.websocket;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$onError$1 extends o implements Function1<WebSocket$Error, Unit> {
    public static final WebSocket$onError$1 INSTANCE = new WebSocket$onError$1();

    public WebSocket$onError$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket$Error webSocket$Error) {
        invoke2(webSocket$Error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket$Error webSocket$Error) {
        m.checkNotNullParameter(webSocket$Error, "it");
    }
}
