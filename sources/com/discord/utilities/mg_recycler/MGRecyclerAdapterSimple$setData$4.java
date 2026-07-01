package com.discord.utilities.mg_recycler;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGRecyclerAdapterSimple$setData$4 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ MGRecyclerAdapterSimple this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerAdapterSimple$setData$4(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        super(1);
        this.this$0 = mGRecyclerAdapterSimple;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        MGRecyclerAdapterSimple.access$setDiffingSubscription$p(this.this$0, subscription);
    }
}
