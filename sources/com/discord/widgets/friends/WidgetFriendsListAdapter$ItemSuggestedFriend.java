package com.discord.widgets.friends;

import com.discord.databinding.WidgetFriendsListAdapterSuggestedFriendBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriend extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListAdapterSuggestedFriendBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetFriendsListAdapter$ItemSuggestedFriend(WidgetFriendsListAdapterSuggestedFriendBinding widgetFriendsListAdapterSuggestedFriendBinding, WidgetFriendsListAdapter widgetFriendsListAdapter) {
        m.checkNotNullParameter(widgetFriendsListAdapterSuggestedFriendBinding, "viewBinding");
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        SuggestedFriendView suggestedFriendView = widgetFriendsListAdapterSuggestedFriendBinding.a;
        m.checkNotNullExpressionValue(suggestedFriendView, "viewBinding.root");
        super(suggestedFriendView, widgetFriendsListAdapter);
        this.viewBinding = widgetFriendsListAdapterSuggestedFriendBinding;
    }

    public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(WidgetFriendsListAdapter$ItemSuggestedFriend widgetFriendsListAdapter$ItemSuggestedFriend) {
        return (WidgetFriendsListAdapter) widgetFriendsListAdapter$ItemSuggestedFriend.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        FriendsListViewModel$Item$SuggestedFriend friendsListViewModel$Item$SuggestedFriend = (FriendsListViewModel$Item$SuggestedFriend) data;
        this.viewBinding.a.setOnClickListener(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1(this, data));
        this.viewBinding.f2395b.setAvatarUrl(friendsListViewModel$Item$SuggestedFriend.getSuggestion().getUser().getId(), Integer.valueOf(friendsListViewModel$Item$SuggestedFriend.getSuggestion().getUser().getDiscriminator()), friendsListViewModel$Item$SuggestedFriend.getSuggestion().getUser().getAvatar());
        this.viewBinding.f2395b.setUsername(friendsListViewModel$Item$SuggestedFriend.getSuggestion().getUser().getUsername());
        this.viewBinding.f2395b.setPublicName(friendsListViewModel$Item$SuggestedFriend.getSuggestion().getPublicName());
        this.viewBinding.f2395b.setOnSendClicked(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$2(this, data));
        this.viewBinding.f2395b.setOnDeclineClicked(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$3(this, data));
    }
}
