package com.discord.stores;

import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$fetchEntryCountsForChannel$1 extends o implements Function1<RestCallState<? extends Map<Integer, ? extends Integer>>, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$fetchEntryCountsForChannel$1(StoreDirectories storeDirectories, long j) {
        super(1);
        this.this$0 = storeDirectories;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Map<Integer, ? extends Integer>> restCallState) {
        invoke2((RestCallState<? extends Map<Integer, Integer>>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<? extends Map<Integer, Integer>> restCallState) {
        m.checkNotNullParameter(restCallState, "response");
        StoreDirectories.access$getDispatcher$p(this.this$0).schedule(new StoreDirectories$fetchEntryCountsForChannel$1$1(this, restCallState));
    }
}
