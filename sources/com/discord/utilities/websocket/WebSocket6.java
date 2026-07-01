package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.websocket.WebSocket$onError$1, reason: use source file name */
/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket6 extends Lambda implements Function1<WebSocket.Error, Unit> {
    public static final WebSocket6 INSTANCE = new WebSocket6();

    public WebSocket6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
    }
}
