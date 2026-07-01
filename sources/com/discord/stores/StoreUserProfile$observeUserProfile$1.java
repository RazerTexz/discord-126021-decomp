package com.discord.stores;

import com.discord.api.user.UserProfile;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile$observeUserProfile$1 extends o implements Function0<UserProfile> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUserProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserProfile$observeUserProfile$1(StoreUserProfile storeUserProfile, long j) {
        super(0);
        this.this$0 = storeUserProfile;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UserProfile invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserProfile invoke() {
        return this.this$0.getUserProfile(this.$userId);
    }
}
