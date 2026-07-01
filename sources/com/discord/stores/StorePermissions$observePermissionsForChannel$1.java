package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePermissions$observePermissionsForChannel$1 extends o implements Function0<Long> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePermissions$observePermissionsForChannel$1(StorePermissions storePermissions, long j) {
        super(0);
        this.this$0 = storePermissions;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return (Long) StorePermissions.access$getPermissionsForChannelsFlattenedSnapshot$p(this.this$0).get(Long.valueOf(this.$channelId));
    }
}
