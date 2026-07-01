package com.discord.stores;

import com.discord.api.user.User;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile$updateUser$1 extends o implements Function0<Unit> {
    public final /* synthetic */ User $user;
    public final /* synthetic */ StoreUserProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserProfile$updateUser$1(StoreUserProfile storeUserProfile, User user) {
        super(0);
        this.this$0 = storeUserProfile;
        this.$user = user;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserProfile.access$handleUser(this.this$0, this.$user);
    }
}
