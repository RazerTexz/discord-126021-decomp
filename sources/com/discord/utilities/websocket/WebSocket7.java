package com.discord.utilities.websocket;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.utilities.websocket.WebSocket$onMessage$1, reason: use source file name */
/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket7 extends Lambda implements Function2<InputStreamReader, Integer, Unit> {
    public static final WebSocket7 INSTANCE = new WebSocket7();

    public WebSocket7() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
        invoke(inputStreamReader, num.intValue());
        return Unit.a;
    }

    public final void invoke(InputStreamReader inputStreamReader, int i) {
        Intrinsics3.checkNotNullParameter(inputStreamReader, "<anonymous parameter 0>");
    }
}
