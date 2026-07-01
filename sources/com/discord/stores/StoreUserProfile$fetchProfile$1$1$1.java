package com.discord.stores;

import com.discord.api.user.UserProfile;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile$fetchProfile$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ UserProfile $userProfile;
    public final /* synthetic */ StoreUserProfile$fetchProfile$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserProfile$fetchProfile$1$1$1(StoreUserProfile$fetchProfile$1$1 storeUserProfile$fetchProfile$1$1, UserProfile userProfile) {
        super(0);
        this.this$0 = storeUserProfile$fetchProfile$1$1;
        this.$userProfile = userProfile;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$userProfile != null) {
            StoreUserProfile.access$getStoreStream$p(this.this$0.this$0.this$0).handleUserProfile(this.$userProfile, this.this$0.this$0.$guildId);
            Function1 function1 = this.this$0.this$0.$onFetchSuccess;
            if (function1 != null) {
            }
        }
    }
}
