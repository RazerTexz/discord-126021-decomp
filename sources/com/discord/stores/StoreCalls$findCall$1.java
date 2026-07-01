package com.discord.stores;

import com.discord.models.domain.ModelCall;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$findCall$1 extends o implements Function1<ModelCall, Boolean> {
    public static final StoreCalls$findCall$1 INSTANCE = new StoreCalls$findCall$1();

    public StoreCalls$findCall$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelCall modelCall) {
        return Boolean.valueOf(invoke2(modelCall));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelCall modelCall) {
        return modelCall != null;
    }
}
