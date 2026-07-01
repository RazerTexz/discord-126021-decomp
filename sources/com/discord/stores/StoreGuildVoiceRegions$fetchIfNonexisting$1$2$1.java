package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGuildVoiceRegions$fetchIfNonexisting$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1(StoreGuildVoiceRegions$fetchIfNonexisting$1$2 storeGuildVoiceRegions$fetchIfNonexisting$1$2) {
        super(0);
        this.this$0 = storeGuildVoiceRegions$fetchIfNonexisting$1$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildVoiceRegions$fetchIfNonexisting$1 storeGuildVoiceRegions$fetchIfNonexisting$1 = this.this$0.this$0;
        StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchFailed(storeGuildVoiceRegions$fetchIfNonexisting$1.this$0, storeGuildVoiceRegions$fetchIfNonexisting$1.$guildId);
    }
}
