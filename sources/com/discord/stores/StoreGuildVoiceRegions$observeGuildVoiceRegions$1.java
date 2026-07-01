package com.discord.stores;

import com.discord.models.domain.ModelVoiceRegion;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildVoiceRegions$observeGuildVoiceRegions$1 extends o implements Function0<List<? extends ModelVoiceRegion>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildVoiceRegions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildVoiceRegions$observeGuildVoiceRegions$1(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        super(0);
        this.this$0 = storeGuildVoiceRegions;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ModelVoiceRegion> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ModelVoiceRegion> invoke2() {
        return this.this$0.getGuildVoiceRegions(this.$guildId);
    }
}
