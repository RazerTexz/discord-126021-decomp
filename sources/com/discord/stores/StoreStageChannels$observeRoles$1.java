package com.discord.stores;

import com.discord.widgets.stage.StageRoles;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$observeRoles$1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends StageRoles>>> {
    public final /* synthetic */ StoreStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageChannels$observeRoles$1(StoreStageChannels storeStageChannels) {
        super(0);
        this.this$0 = storeStageChannels;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends StageRoles>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Map<Long, ? extends StageRoles>> invoke2() {
        return StoreStageChannels.access$getStageRolesByChannelSnapshot$p(this.this$0);
    }
}
