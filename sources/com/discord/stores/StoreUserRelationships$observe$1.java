package com.discord.stores;

import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRelationships$observe$1 extends o implements Function0<Map<Long, ? extends Integer>> {
    public final /* synthetic */ StoreUserRelationships this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserRelationships$observe$1(StoreUserRelationships storeUserRelationships) {
        super(0);
        this.this$0 = storeUserRelationships;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Integer> invoke2() {
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsStateAccess$getRelationshipsStateSnapshot$p = StoreUserRelationships.access$getRelationshipsStateSnapshot$p(this.this$0);
        if (m.areEqual(storeUserRelationships$UserRelationshipsStateAccess$getRelationshipsStateSnapshot$p, StoreUserRelationships$UserRelationshipsState$Unloaded.INSTANCE)) {
            return h0.emptyMap();
        }
        if (!(storeUserRelationships$UserRelationshipsStateAccess$getRelationshipsStateSnapshot$p instanceof StoreUserRelationships$UserRelationshipsState$Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreUserRelationships$UserRelationshipsState storeUserRelationships$UserRelationshipsStateAccess$getRelationshipsStateSnapshot$p2 = StoreUserRelationships.access$getRelationshipsStateSnapshot$p(this.this$0);
        Objects.requireNonNull(storeUserRelationships$UserRelationshipsStateAccess$getRelationshipsStateSnapshot$p2, "null cannot be cast to non-null type com.discord.stores.StoreUserRelationships.UserRelationshipsState.Loaded");
        return ((StoreUserRelationships$UserRelationshipsState$Loaded) storeUserRelationships$UserRelationshipsStateAccess$getRelationshipsStateSnapshot$p2).getRelationships();
    }
}
