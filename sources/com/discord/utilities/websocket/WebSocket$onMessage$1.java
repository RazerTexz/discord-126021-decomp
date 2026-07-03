package com.discord.utilities.websocket;

import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$onMessage$1 extends AbstractC12240o implements Function2<InputStreamReader, Integer, Unit> {
    public static final WebSocket$onMessage$1 INSTANCE = new WebSocket$onMessage$1();

    public WebSocket$onMessage$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
        invoke(inputStreamReader, num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(InputStreamReader inputStreamReader, int i) {
        C12238m.checkNotNullParameter(inputStreamReader, "<anonymous parameter 0>");
    }
}
