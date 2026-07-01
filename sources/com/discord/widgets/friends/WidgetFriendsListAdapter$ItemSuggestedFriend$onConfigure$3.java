package com.discord.widgets.friends;

import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FriendsListViewModel.Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemSuggestedFriend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$3(WidgetFriendsListAdapter.ItemSuggestedFriend itemSuggestedFriend, FriendsListViewModel.Item item) {
        super(0);
        this.this$0 = itemSuggestedFriend;
        this.$data = item;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetFriendsListAdapter.ItemSuggestedFriend.access$getAdapter$p(this.this$0).getOnClickRemoveSuggestion().invoke(Long.valueOf(((FriendsListViewModel.Item.SuggestedFriend) this.$data).getSuggestion().getUser().getId()));
    }
}
