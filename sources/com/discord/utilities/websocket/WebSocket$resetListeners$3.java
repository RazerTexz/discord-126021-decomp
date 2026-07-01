package com.discord.utilities.websocket;

import d0.z.d.m;
import d0.z.d.o;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$resetListeners$3 extends o implements Function2<InputStreamReader, Integer, Unit> {
    public static final WebSocket$resetListeners$3 INSTANCE = new WebSocket$resetListeners$3();

    public WebSocket$resetListeners$3() {
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
