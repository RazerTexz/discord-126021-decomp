package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserRelationships.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserRelationships$observeUserRelationshipsState$1 extends o implements Function0<StoreUserRelationships$UserRelationshipsState> {
    public final /* synthetic */ StoreUserRelationships this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserRelationships$observeUserRelationshipsState$1(StoreUserRelationships storeUserRelationships) {
        super(0);
        this.this$0 = storeUserRelationships;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreUserRelationships$UserRelationshipsState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreUserRelationships$UserRelationshipsState invoke() {
        return this.this$0.getRelationshipsStateSnapshot();
    }
}
