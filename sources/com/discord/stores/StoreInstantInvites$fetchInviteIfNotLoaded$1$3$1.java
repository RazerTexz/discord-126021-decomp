package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreInstantInvites$fetchInviteIfNotLoaded$1$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1(StoreInstantInvites$fetchInviteIfNotLoaded$1$3 storeInstantInvites$fetchInviteIfNotLoaded$1$3) {
        super(0);
        this.this$0 = storeInstantInvites$fetchInviteIfNotLoaded$1$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreInstantInvites$fetchInviteIfNotLoaded$1 storeInstantInvites$fetchInviteIfNotLoaded$1 = this.this$0.this$0;
        StoreInstantInvites storeInstantInvites = storeInstantInvites$fetchInviteIfNotLoaded$1.this$0;
        String str = storeInstantInvites$fetchInviteIfNotLoaded$1.$inviteKey;
        m.checkNotNullExpressionValue(str, "inviteKey");
        StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, StoreInstantInvites$InviteState$Invalid.INSTANCE);
    }
}
