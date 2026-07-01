package com.discord.utilities.websocket;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$connect$1$onClosed$1 extends o implements Function0<Unit> {
    public final /* synthetic */ int $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ WebSocket$connect$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket$connect$1$onClosed$1(WebSocket$connect$1 webSocket$connect$1, int i, String str) {
        super(0);
        this.this$0 = webSocket$connect$1;
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
        WebSocket.access$setState$p(this.this$0.this$0, WebSocket$State.CLOSED);
        this.this$0.this$0.getOnClosed().invoke(new WebSocket$Closed(this.$code, this.$reason));
    }
}
