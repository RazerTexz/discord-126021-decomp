package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.websocket.WebSocket$connect$1$onClosed$1, reason: use source file name */
/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ WebSocket.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket2(WebSocket.AnonymousClass1 anonymousClass1, int i, String str) {
        super(0);
        this.this$0 = anonymousClass1;
        this.$code = i;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebSocket.this.state = WebSocket.State.CLOSED;
        WebSocket.this.getOnClosed().invoke(new WebSocket.Closed(this.$code, this.$reason));
    }
}
