package com.discord.rtcconnection;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcConnection$e extends o implements Function0<Unit> {
    public final /* synthetic */ RtcConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RtcConnection$e(RtcConnection rtcConnection) {
        super(0);
        this.this$0 = rtcConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.this$0.f("Force Close");
        return Unit.a;
    }
}
