package com.discord.stores;

import com.discord.models.domain.ModelUserAffinities;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities$observeUserAffinities$1 extends o implements Function0<ModelUserAffinities> {
    public final /* synthetic */ StoreUserAffinities this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserAffinities$observeUserAffinities$1(StoreUserAffinities storeUserAffinities) {
        super(0);
        this.this$0 = storeUserAffinities;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ModelUserAffinities invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ModelUserAffinities invoke() {
        return StoreUserAffinities.access$getAffinitiesSnapshot$p(this.this$0);
    }
}
