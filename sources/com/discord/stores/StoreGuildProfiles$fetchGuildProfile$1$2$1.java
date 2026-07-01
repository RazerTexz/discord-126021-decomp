package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildProfiles$fetchGuildProfile$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGuildProfiles$fetchGuildProfile$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildProfiles$fetchGuildProfile$1$2$1(StoreGuildProfiles$fetchGuildProfile$1$2 storeGuildProfiles$fetchGuildProfile$1$2) {
        super(0);
        this.this$0 = storeGuildProfiles$fetchGuildProfile$1$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildProfiles$fetchGuildProfile$1 storeGuildProfiles$fetchGuildProfile$1 = this.this$0.this$0;
        StoreGuildProfiles.access$handleGuildProfileFetchFailed(storeGuildProfiles$fetchGuildProfile$1.this$0, storeGuildProfiles$fetchGuildProfile$1.$guildId);
    }
}
