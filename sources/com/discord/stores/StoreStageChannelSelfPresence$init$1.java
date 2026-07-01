package com.discord.stores;

import com.discord.widgets.stage.StageRoles;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannelSelfPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence$init$1 extends o implements Function0<Integer> {
    public final /* synthetic */ StoreStageChannelSelfPresence this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannelSelfPresence$init$1(StoreStageChannelSelfPresence storeStageChannelSelfPresence) {
        super(0);
        this.this$0 = storeStageChannelSelfPresence;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        Map<Long, StageRoles> channelRolesInternal = this.this$0.getStageChannels().getChannelRolesInternal(this.this$0.getVoiceChannelSelected().getSelectedVoiceChannelId());
        return ((channelRolesInternal != null ? channelRolesInternal.size() : 0) / 100) + 1;
    }
}
