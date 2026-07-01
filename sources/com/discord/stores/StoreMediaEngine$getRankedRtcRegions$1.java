package com.discord.stores;

import d0.t.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$getRankedRtcRegions$1 extends o implements Function1<String[], Unit> {
    public final /* synthetic */ Function1 $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$getRankedRtcRegions$1(Function1 function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
        invoke2(strArr);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String[] strArr) {
        m.checkNotNullParameter(strArr, "it");
        this.$callback.invoke(k.toList(strArr));
    }
}
