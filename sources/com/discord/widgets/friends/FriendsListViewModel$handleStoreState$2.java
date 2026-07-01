package com.discord.widgets.friends;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$handleStoreState$2 extends o implements Function1<FriendsListViewModel$ListSections, Unit> {
    public final /* synthetic */ FriendsListViewModel$StoreState $storeState;
    public final /* synthetic */ FriendsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$handleStoreState$2(FriendsListViewModel friendsListViewModel, FriendsListViewModel$StoreState friendsListViewModel$StoreState) {
        super(1);
        this.this$0 = friendsListViewModel;
        this.$storeState = friendsListViewModel$StoreState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel$ListSections friendsListViewModel$ListSections) {
        invoke2(friendsListViewModel$ListSections);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FriendsListViewModel$ListSections friendsListViewModel$ListSections) {
        m.checkNotNullParameter(friendsListViewModel$ListSections, "it");
        FriendsListViewModel.access$handleComputedItems(this.this$0, friendsListViewModel$ListSections, this.$storeState.getShowContactSyncIcon());
    }
}
