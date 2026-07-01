package com.discord.stores;

import d0.t.n0;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMembers$observeThreadMembers$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreThreadMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMembers$observeThreadMembers$1(StoreThreadMembers storeThreadMembers, long j) {
        super(0);
        this.this$0 = storeThreadMembers;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        Set<? extends Long> set = (Set) StoreThreadMembers.access$getMemberListsSnapshot$p(this.this$0).get(Long.valueOf(this.$channelId));
        return set != null ? set : n0.emptySet();
    }
}
