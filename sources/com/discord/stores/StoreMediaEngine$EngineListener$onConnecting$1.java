package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$EngineListener$onConnecting$1 extends o implements Function1<StoreMediaEngine$Listener, Unit> {
    public static final StoreMediaEngine$EngineListener$onConnecting$1 INSTANCE = new StoreMediaEngine$EngineListener$onConnecting$1();

    public StoreMediaEngine$EngineListener$onConnecting$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMediaEngine$Listener storeMediaEngine$Listener) {
        invoke2(storeMediaEngine$Listener);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMediaEngine$Listener storeMediaEngine$Listener) {
        m.checkNotNullParameter(storeMediaEngine$Listener, "it");
        storeMediaEngine$Listener.onConnecting();
    }
}
