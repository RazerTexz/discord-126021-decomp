package com.discord.stores;

import com.discord.stores.StoreMediaEngine;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$EngineListener$onConnecting$1 extends Lambda implements Function1<StoreMediaEngine.Listener, Unit> {
    public static final StoreMediaEngine$EngineListener$onConnecting$1 INSTANCE = new StoreMediaEngine$EngineListener$onConnecting$1();

    public StoreMediaEngine$EngineListener$onConnecting$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMediaEngine.Listener listener) {
        invoke2(listener);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMediaEngine.Listener listener) {
        Intrinsics3.checkNotNullParameter(listener, "it");
        listener.onConnecting();
    }
}
