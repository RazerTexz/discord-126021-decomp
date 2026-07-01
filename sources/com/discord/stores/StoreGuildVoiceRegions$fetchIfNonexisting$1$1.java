package com.discord.stores;

import com.discord.models.domain.ModelVoiceRegion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildVoiceRegions$fetchIfNonexisting$1$1 extends o implements Function1<List<? extends ModelVoiceRegion>, Unit> {
    public final /* synthetic */ StoreGuildVoiceRegions$fetchIfNonexisting$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildVoiceRegions$fetchIfNonexisting$1$1(StoreGuildVoiceRegions$fetchIfNonexisting$1 storeGuildVoiceRegions$fetchIfNonexisting$1) {
        super(1);
        this.this$0 = storeGuildVoiceRegions$fetchIfNonexisting$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelVoiceRegion> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ModelVoiceRegion> list) {
        m.checkNotNullParameter(list, "voiceRegions");
        StoreGuildVoiceRegions.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreGuildVoiceRegions$fetchIfNonexisting$1$1$1(this, list));
    }
}
