package com.discord.stores;

import com.discord.models.domain.ModelUserAffinities;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities$fetchUserAffinities$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelUserAffinities $affinities;
    public final /* synthetic */ StoreUserAffinities$fetchUserAffinities$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserAffinities$fetchUserAffinities$1$1(StoreUserAffinities$fetchUserAffinities$1 storeUserAffinities$fetchUserAffinities$1, ModelUserAffinities modelUserAffinities) {
        super(0);
        this.this$0 = storeUserAffinities$fetchUserAffinities$1;
        this.$affinities = modelUserAffinities;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserAffinities.access$handleUserAffinitiesFetchSuccess(this.this$0.this$0, this.$affinities);
    }
}
