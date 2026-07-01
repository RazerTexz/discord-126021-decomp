package com.discord.stores;

import com.discord.api.application.Application;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication$fetchIfNonexisting$1$1 extends o implements Function1<List<? extends Application>, Unit> {
    public final /* synthetic */ StoreApplication$fetchIfNonexisting$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplication$fetchIfNonexisting$1$1(StoreApplication$fetchIfNonexisting$1 storeApplication$fetchIfNonexisting$1) {
        super(1);
        this.this$0 = storeApplication$fetchIfNonexisting$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
        invoke2((List<Application>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Application> list) {
        m.checkNotNullParameter(list, "results");
        StoreApplication.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreApplication$fetchIfNonexisting$1$1$1(this, list));
    }
}
