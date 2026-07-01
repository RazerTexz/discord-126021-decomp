package com.discord.widgets.stage;

import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel$observe$1 extends o implements Function0<Set<? extends Long>> {
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreStageInstances $storeStageInstances;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIdsWithVisibleStageInstanceModel$observe$1(StoreStageInstances storeStageInstances, StorePermissions storePermissions) {
        super(0);
        this.$storeStageInstances = storeStageInstances;
        this.$storePermissions = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends Long> invoke2() {
        return GuildIdsWithVisibleStageInstanceModel.INSTANCE.compute(this.$storeStageInstances.getStageInstancesByGuild(), this.$storePermissions.getPermissionsByChannel());
    }
}
