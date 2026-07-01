package com.discord.widgets.friends;

import d0.t.n0;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$getItems$3 extends o implements Function1<Integer, Boolean> {
    public static final FriendsListViewModel$getItems$3 INSTANCE = new FriendsListViewModel$getItems$3();

    public FriendsListViewModel$getItems$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return Boolean.valueOf(invoke(num.intValue()));
    }

    public final boolean invoke(int i) {
        return n0.setOf((Object[]) new Integer[]{3, 4}).contains(Integer.valueOf(i));
    }
}
