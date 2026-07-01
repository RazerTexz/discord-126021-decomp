package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchGuildInvites$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $invites;
    public final /* synthetic */ StoreInstantInvites$fetchGuildInvites$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchGuildInvites$1$1(StoreInstantInvites$fetchGuildInvites$1 storeInstantInvites$fetchGuildInvites$1, List list) {
        super(0);
        this.this$0 = storeInstantInvites$fetchGuildInvites$1;
        this.$invites = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreInstantInvites.access$onLoadedInvites(this.this$0.this$0, this.$invites);
    }
}
