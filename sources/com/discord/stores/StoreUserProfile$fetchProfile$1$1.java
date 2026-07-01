package com.discord.stores;

import com.discord.api.user.UserProfile;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile$fetchProfile$1$1 extends o implements Function1<UserProfile, Unit> {
    public final /* synthetic */ StoreUserProfile$fetchProfile$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserProfile$fetchProfile$1$1(StoreUserProfile$fetchProfile$1 storeUserProfile$fetchProfile$1) {
        super(1);
        this.this$0 = storeUserProfile$fetchProfile$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
        invoke2(userProfile);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfile userProfile) {
        StoreUserProfile.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreUserProfile$fetchProfile$1$1$1(this, userProfile));
    }
}
