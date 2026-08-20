package com.discord.utilities.websocket;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$onClosed$1 extends AbstractC12240o implements Function1<WebSocket.Closed, Unit> {
    public static final WebSocket$onClosed$1 INSTANCE = new WebSocket$onClosed$1();

    public WebSocket$onClosed$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Closed closed) {
        invoke2(closed);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Closed closed) {
        C12238m.checkNotNullParameter(closed, "it");
    }
}
