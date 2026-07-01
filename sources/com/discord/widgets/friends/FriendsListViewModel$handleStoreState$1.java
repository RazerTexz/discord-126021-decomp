package com.discord.widgets.friends;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$handleStoreState$1 extends o implements Function0<FriendsListViewModel$ListSections> {
    public final /* synthetic */ Map $relationships;
    public final /* synthetic */ FriendsListViewModel$StoreState $storeState;
    public final /* synthetic */ FriendsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$handleStoreState$1(FriendsListViewModel friendsListViewModel, Map map, FriendsListViewModel$StoreState friendsListViewModel$StoreState) {
        super(0);
        this.this$0 = friendsListViewModel;
        this.$relationships = map;
        this.$storeState = friendsListViewModel$StoreState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FriendsListViewModel$ListSections invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FriendsListViewModel$ListSections invoke() {
        return FriendsListViewModel.access$getItems(this.this$0, this.$relationships, this.$storeState.getUsers(), this.$storeState.getPresences(), this.$storeState.getApplicationStreams(), this.$storeState.getShowContactSyncUpsell(), this.$storeState.getFriendSuggestions());
    }
}
