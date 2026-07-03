package com.discord.stores;

import com.discord.stores.StoreThreadMessages;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreThreadMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMessages$deleteForParentChannel$removed$1 extends AbstractC12240o implements Function1<StoreThreadMessages.ThreadState, Boolean> {
    public final /* synthetic */ long $parentChannelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMessages$deleteForParentChannel$removed$1(long j) {
        super(1);
        this.$parentChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadMessages.ThreadState threadState) {
        return Boolean.valueOf(invoke2(threadState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadMessages.ThreadState threadState) {
        C12238m.checkNotNullParameter(threadState, "thread");
        return threadState.getParentId() == this.$parentChannelId;
    }
}
