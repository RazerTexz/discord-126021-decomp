package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildVoiceRegions$fetchIfNonexisting$1$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreGuildVoiceRegions$fetchIfNonexisting$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildVoiceRegions$fetchIfNonexisting$1$2(StoreGuildVoiceRegions$fetchIfNonexisting$1 storeGuildVoiceRegions$fetchIfNonexisting$1) {
        super(1);
        this.this$0 = storeGuildVoiceRegions$fetchIfNonexisting$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreGuildVoiceRegions.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1(this));
    }
}
