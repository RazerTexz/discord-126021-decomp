package com.discord.stores;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeUsernames$1 extends o implements Function1<User, String> {
    public static final StoreUser$observeUsernames$1 INSTANCE = new StoreUser$observeUsernames$1();

    public StoreUser$observeUsernames$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(User user) {
        return invoke2(user);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(User user) {
        m.checkNotNull(user);
        return user.getUsername();
    }
}
