package com.discord.stores;

import d0.z.d.o;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$handleConnectionOpen$4$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Set $newThreadIds;
    public final /* synthetic */ Set $oldThreadIds;
    public final /* synthetic */ StoreMessageAck$handleConnectionOpen$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$handleConnectionOpen$4$1(StoreMessageAck$handleConnectionOpen$4 storeMessageAck$handleConnectionOpen$4, Set set, Set set2) {
        super(0);
        this.this$0 = storeMessageAck$handleConnectionOpen$4;
        this.$oldThreadIds = set;
        this.$newThreadIds = set2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessageAck.access$updateThreadAcks(this.this$0.this$0, this.$oldThreadIds, this.$newThreadIds);
    }
}
