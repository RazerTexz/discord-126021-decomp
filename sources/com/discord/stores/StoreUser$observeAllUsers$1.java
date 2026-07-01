package com.discord.stores;

import com.discord.models.user.User;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeAllUsers$1 extends o implements Function0<Map<Long, ? extends User>> {
    public final /* synthetic */ StoreUser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$observeAllUsers$1(StoreUser storeUser) {
        super(0);
        this.this$0 = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends User> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends User> invoke2() {
        return this.this$0.getUsers();
    }
}
