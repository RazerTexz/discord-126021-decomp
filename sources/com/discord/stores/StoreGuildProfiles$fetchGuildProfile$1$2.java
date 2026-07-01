package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildProfiles$fetchGuildProfile$1$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreGuildProfiles$fetchGuildProfile$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildProfiles$fetchGuildProfile$1$2(StoreGuildProfiles$fetchGuildProfile$1 storeGuildProfiles$fetchGuildProfile$1) {
        super(1);
        this.this$0 = storeGuildProfiles$fetchGuildProfile$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreGuildProfiles.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildProfiles$fetchGuildProfile$1$2$1(this));
    }
}
