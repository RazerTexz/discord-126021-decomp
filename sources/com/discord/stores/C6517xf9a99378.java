package com.discord.stores;

import com.discord.stores.StoreStreamRtcConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreStreamRtcConnection$RtcConnectionListener$onFirstFrameSent$1 */
/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6517xf9a99378 extends AbstractC12240o implements Function1<StoreStreamRtcConnection.Listener, Unit> {
    public static final C6517xf9a99378 INSTANCE = new C6517xf9a99378();

    public C6517xf9a99378() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreStreamRtcConnection.Listener listener) {
        invoke2(listener);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreStreamRtcConnection.Listener listener) {
        C12238m.checkNotNullParameter(listener, "it");
        listener.onFirstFrameSent();
    }
}
