package com.discord.utilities.websocket;

import d0.z.d.m;
import d0.z.d.o;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$onMessage$1 extends o implements Function2<InputStreamReader, Integer, Unit> {
    public static final WebSocket$onMessage$1 INSTANCE = new WebSocket$onMessage$1();

    public WebSocket$onMessage$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
        invoke(inputStreamReader, num.intValue());
        return Unit.a;
    }

    public final void invoke(InputStreamReader inputStreamReader, int i) {
        m.checkNotNullParameter(inputStreamReader, "<anonymous parameter 0>");
    }
}
