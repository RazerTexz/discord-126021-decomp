package com.discord.widgets.friends;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$acceptFriendRequest$2$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ FriendsListViewModel$acceptFriendRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$acceptFriendRequest$2$2(FriendsListViewModel$acceptFriendRequest$2 friendsListViewModel$acceptFriendRequest$2) {
        super(0);
        this.this$0 = friendsListViewModel$acceptFriendRequest$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        FriendsListViewModel.access$emitShowToastEvent(this.this$0.this$0, 2131888366);
        return false;
    }
}
