package com.discord.widgets.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListAdapterSuggestedFriendBinding;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter extends MGRecyclerAdapterSimple<FriendsListViewModel$Item> {
    private Function1<? super User, Unit> onClickAcceptFriend;
    private Function1<? super User, Unit> onClickApproveSuggestion;
    private Function1<? super User, Unit> onClickCall;
    private Function1<? super User, Unit> onClickChat;
    private Function0<Unit> onClickContactSyncUpsell;
    private Function1<? super View, Unit> onClickContactSyncUpsellLongClick;
    private Function2<? super User, ? super Integer, Unit> onClickDeclineFriend;
    private Function0<Unit> onClickPendingHeaderExpand;
    private Function1<? super Long, Unit> onClickRemoveSuggestion;
    private Function0<Unit> onClickSuggestedHeaderExpandCollapse;
    private Function2<? super View, ? super User, Unit> onClickUserProfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSuggestedHeaderExpandCollapse = WidgetFriendsListAdapter$onClickSuggestedHeaderExpandCollapse$1.INSTANCE;
        this.onClickPendingHeaderExpand = WidgetFriendsListAdapter$onClickPendingHeaderExpand$1.INSTANCE;
        this.onClickUserProfile = WidgetFriendsListAdapter$onClickUserProfile$1.INSTANCE;
        this.onClickCall = WidgetFriendsListAdapter$onClickCall$1.INSTANCE;
        this.onClickChat = WidgetFriendsListAdapter$onClickChat$1.INSTANCE;
        this.onClickAcceptFriend = WidgetFriendsListAdapter$onClickAcceptFriend$1.INSTANCE;
        this.onClickDeclineFriend = WidgetFriendsListAdapter$onClickDeclineFriend$1.INSTANCE;
        this.onClickApproveSuggestion = WidgetFriendsListAdapter$onClickApproveSuggestion$1.INSTANCE;
        this.onClickRemoveSuggestion = WidgetFriendsListAdapter$onClickRemoveSuggestion$1.INSTANCE;
        this.onClickContactSyncUpsell = WidgetFriendsListAdapter$onClickContactSyncUpsell$1.INSTANCE;
        this.onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter$onClickContactSyncUpsellLongClick$1.INSTANCE;
    }

    public final Function1<User, Unit> getOnClickAcceptFriend() {
        return this.onClickAcceptFriend;
    }

    public final Function1<User, Unit> getOnClickApproveSuggestion() {
        return this.onClickApproveSuggestion;
    }

    public final Function1<User, Unit> getOnClickCall() {
        return this.onClickCall;
    }

    public final Function1<User, Unit> getOnClickChat() {
        return this.onClickChat;
    }

    public final Function0<Unit> getOnClickContactSyncUpsell() {
        return this.onClickContactSyncUpsell;
    }

    public final Function1<View, Unit> getOnClickContactSyncUpsellLongClick() {
        return this.onClickContactSyncUpsellLongClick;
    }

    public final Function2<User, Integer, Unit> getOnClickDeclineFriend() {
        return this.onClickDeclineFriend;
    }

    public final Function0<Unit> getOnClickPendingHeaderExpand() {
        return this.onClickPendingHeaderExpand;
    }

    public final Function1<Long, Unit> getOnClickRemoveSuggestion() {
        return this.onClickRemoveSuggestion;
    }

    public final Function0<Unit> getOnClickSuggestedHeaderExpandCollapse() {
        return this.onClickSuggestedHeaderExpandCollapse;
    }

    public final Function2<View, User, Unit> getOnClickUserProfile() {
        return this.onClickUserProfile;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickAcceptFriend(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickAcceptFriend = function1;
    }

    public final void setOnClickApproveSuggestion(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickApproveSuggestion = function1;
    }

    public final void setOnClickCall(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickCall = function1;
    }

    public final void setOnClickChat(Function1<? super User, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickChat = function1;
    }

    public final void setOnClickContactSyncUpsell(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onClickContactSyncUpsell = function0;
    }

    public final void setOnClickContactSyncUpsellLongClick(Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickContactSyncUpsellLongClick = function1;
    }

    public final void setOnClickDeclineFriend(Function2<? super User, ? super Integer, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onClickDeclineFriend = function2;
    }

    public final void setOnClickPendingHeaderExpand(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onClickPendingHeaderExpand = function0;
    }

    public final void setOnClickRemoveSuggestion(Function1<? super Long, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClickRemoveSuggestion = function1;
    }

    public final void setOnClickSuggestedHeaderExpandCollapse(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onClickSuggestedHeaderExpandCollapse = function0;
    }

    public final void setOnClickUserProfile(Function2<? super View, ? super User, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onClickUserProfile = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, FriendsListViewModel$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new WidgetFriendsListAdapter$ItemUser(this);
            case 1:
                return new WidgetFriendsListAdapter$ItemPendingUser(this);
            case 2:
                return new WidgetFriendsListAdapter$ItemPendingHeader(this);
            case 3:
                return new WidgetFriendsListAdapter$ItemHeader(this);
            case 4:
                return new WidgetFriendsListAdapter$ItemSuggestedFriendHeader(this);
            case 5:
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_friends_list_adapter_suggested_friend, parent, false);
                Objects.requireNonNull(viewInflate, "rootView");
                SuggestedFriendView suggestedFriendView = (SuggestedFriendView) viewInflate;
                WidgetFriendsListAdapterSuggestedFriendBinding widgetFriendsListAdapterSuggestedFriendBinding = new WidgetFriendsListAdapterSuggestedFriendBinding(suggestedFriendView, suggestedFriendView);
                m.checkNotNullExpressionValue(widgetFriendsListAdapterSuggestedFriendBinding, "WidgetFriendsListAdapter…          false\n        )");
                return new WidgetFriendsListAdapter$ItemSuggestedFriend(widgetFriendsListAdapterSuggestedFriendBinding, this);
            case 6:
                return new WidgetFriendsListAdapter$ItemContactSyncUpsell(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
