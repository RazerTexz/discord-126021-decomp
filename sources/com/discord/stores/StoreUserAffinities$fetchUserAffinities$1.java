package com.discord.stores;

import com.discord.models.domain.ModelUserAffinities;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserAffinities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserAffinities$fetchUserAffinities$1 extends o implements Function1<ModelUserAffinities, Unit> {
    public final /* synthetic */ StoreUserAffinities this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserAffinities$fetchUserAffinities$1(StoreUserAffinities storeUserAffinities) {
        super(1);
        this.this$0 = storeUserAffinities;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserAffinities modelUserAffinities) {
        invoke2(modelUserAffinities);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserAffinities modelUserAffinities) {
        m.checkNotNullParameter(modelUserAffinities, "affinities");
        StoreUserAffinities.access$getDispatcher$p(this.this$0).schedule(new StoreUserAffinities$fetchUserAffinities$1$1(this, modelUserAffinities));
    }
}
