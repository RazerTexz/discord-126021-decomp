package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$observeTypingUsers$1 extends o implements Function0<Map<Long, ? extends Set<? extends Long>>> {
    public final /* synthetic */ StoreUserTyping this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$observeTypingUsers$1(StoreUserTyping storeUserTyping) {
        super(0);
        this.this$0 = storeUserTyping;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Set<? extends Long>> invoke2() {
        return StoreUserTyping.access$getTypingUsers(this.this$0);
    }
}
