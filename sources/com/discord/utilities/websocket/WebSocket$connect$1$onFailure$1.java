package com.discord.utilities.websocket;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.Response;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$connect$1$onFailure$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Response $response;

    /* JADX INFO: renamed from: $t */
    public final /* synthetic */ Throwable f19002$t;
    public final /* synthetic */ WebSocket.C70581 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket$connect$1$onFailure$1(WebSocket.C70581 c70581, Throwable th, Response response) {
        super(0);
        this.this$0 = c70581;
        this.f19002$t = th;
        this.$response = response;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebSocket.this.handleOnFailure(this.f19002$t, this.$response, true);
    }
}
