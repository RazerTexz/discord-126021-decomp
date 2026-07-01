package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNux.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNux$setPostRegisterWithInvite$1 extends o implements Function1<StoreNux$NuxState, StoreNux$NuxState> {
    public final /* synthetic */ boolean $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNux$setPostRegisterWithInvite$1(boolean z2) {
        super(1);
        this.$value = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreNux$NuxState invoke(StoreNux$NuxState storeNux$NuxState) {
        return invoke2(storeNux$NuxState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreNux$NuxState invoke2(StoreNux$NuxState storeNux$NuxState) {
        m.checkNotNullParameter(storeNux$NuxState, "it");
        return StoreNux$NuxState.copy$default(storeNux$NuxState, false, this.$value, false, false, false, null, 61, null);
    }
}
