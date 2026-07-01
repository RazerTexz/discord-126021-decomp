package com.discord.stores;

import com.discord.models.user.MeUser;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeMe$1 extends o implements Function0<MeUser> {
    public final /* synthetic */ StoreUser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$observeMe$1(StoreUser storeUser) {
        super(0);
        this.this$0 = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MeUser invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MeUser invoke() {
        return StoreUser.access$getMe$p(this.this$0);
    }
}
