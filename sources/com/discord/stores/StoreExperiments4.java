package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreExperiments$getGuildExperiment$experiment$1, reason: use source file name */
/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int $bucket;
    public final /* synthetic */ String $experimentName;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ int $revision;
    public final /* synthetic */ StoreExperiments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExperiments4(StoreExperiments storeExperiments, String str, long j, int i, int i2) {
        super(0);
        this.this$0 = storeExperiments;
        this.$experimentName = str;
        this.$guildId = j;
        this.$bucket = i;
        this.$revision = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.trackExposureToGuildExperiment(this.$experimentName, this.$guildId, this.$bucket, this.$revision);
    }
}
