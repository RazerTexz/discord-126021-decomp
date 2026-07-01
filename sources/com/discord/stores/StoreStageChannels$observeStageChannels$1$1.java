package com.discord.stores;

import com.discord.widgets.stage.model.StageChannel;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$observeStageChannels$1$1 extends o implements Function1<Long, Map<Long, ? extends StageChannel>> {
    public final /* synthetic */ StoreStageChannels$observeStageChannels$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannels$observeStageChannels$1$1(StoreStageChannels$observeStageChannels$1 storeStageChannels$observeStageChannels$1) {
        super(1);
        this.this$0 = storeStageChannels$observeStageChannels$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Map<Long, ? extends StageChannel> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Map<Long, StageChannel> invoke(long j) {
        return StoreStageChannels.getStageChannelsInGuild$default(this.this$0.this$0, j, null, 0L, null, null, 30, null);
    }
}
