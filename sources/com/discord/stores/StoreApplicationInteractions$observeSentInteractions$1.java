package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$observeSentInteractions$1 extends o implements Function0<Map<String, ? extends StoreApplicationInteractions$SentInteraction>> {
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$observeSentInteractions$1(StoreApplicationInteractions storeApplicationInteractions) {
        super(0);
        this.this$0 = storeApplicationInteractions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends StoreApplicationInteractions$SentInteraction> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends StoreApplicationInteractions$SentInteraction> invoke2() {
        return StoreApplicationInteractions.access$getSentInteractionsSnapshot$p(this.this$0);
    }
}
