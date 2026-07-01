package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMFA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMFA$observeState$1 extends o implements Function0<StoreMFA$State> {
    public final /* synthetic */ StoreMFA this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMFA$observeState$1(StoreMFA storeMFA) {
        super(0);
        this.this$0 = storeMFA;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreMFA$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreMFA$State invoke() {
        return StoreMFA.access$getState$p(this.this$0);
    }
}
