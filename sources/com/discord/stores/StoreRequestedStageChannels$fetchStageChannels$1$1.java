package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels$fetchStageChannels$1$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ Set $channelIdsToRequest;
    public final /* synthetic */ StoreRequestedStageChannels$fetchStageChannels$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRequestedStageChannels$fetchStageChannels$1$1(StoreRequestedStageChannels$fetchStageChannels$1 storeRequestedStageChannels$fetchStageChannels$1, Set set) {
        super(1);
        this.this$0 = storeRequestedStageChannels$fetchStageChannels$1;
        this.$channelIdsToRequest = set;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreRequestedStageChannels.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreRequestedStageChannels$fetchStageChannels$1$1$1(this));
    }
}
