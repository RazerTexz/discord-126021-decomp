package com.discord.widgets.friends;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$1 extends o implements Function1<FriendsListViewModel$StoreState, Unit> {
    public final /* synthetic */ FriendsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$1(FriendsListViewModel friendsListViewModel) {
        super(1);
        this.this$0 = friendsListViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel$StoreState friendsListViewModel$StoreState) throws Exception {
        invoke2(friendsListViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FriendsListViewModel$StoreState friendsListViewModel$StoreState) throws Exception {
        m.checkNotNullParameter(friendsListViewModel$StoreState, "storeState");
        FriendsListViewModel.access$handleStoreState(this.this$0, friendsListViewModel$StoreState);
    }
}
