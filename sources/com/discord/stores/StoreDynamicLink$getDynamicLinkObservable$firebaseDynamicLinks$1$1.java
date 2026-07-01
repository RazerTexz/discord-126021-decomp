package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Emitter;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1 extends k implements Function1<Throwable, Unit> {
    public StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1(Emitter emitter) {
        super(1, emitter, Emitter.class, "onError", "onError(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        ((Emitter) this.receiver).onError(th);
    }
}
