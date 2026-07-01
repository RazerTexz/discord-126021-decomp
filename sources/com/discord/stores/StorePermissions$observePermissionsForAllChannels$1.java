package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePermissions$observePermissionsForAllChannels$1 extends o implements Function0<Map<Long, ? extends Long>> {
    public final /* synthetic */ StorePermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePermissions$observePermissionsForAllChannels$1(StorePermissions storePermissions) {
        super(0);
        this.this$0 = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Long> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Long> invoke2() {
        return StorePermissions.access$getPermissionsForChannelsFlattenedSnapshot$p(this.this$0);
    }
}
