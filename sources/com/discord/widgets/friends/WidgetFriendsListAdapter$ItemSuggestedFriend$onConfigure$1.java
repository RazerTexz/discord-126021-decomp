package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.User;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ FriendsListViewModel$Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter$ItemSuggestedFriend this$0;

    public WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1(WidgetFriendsListAdapter$ItemSuggestedFriend widgetFriendsListAdapter$ItemSuggestedFriend, FriendsListViewModel$Item friendsListViewModel$Item) {
        this.this$0 = widgetFriendsListAdapter$ItemSuggestedFriend;
        this.$data = friendsListViewModel$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter$ItemSuggestedFriend.access$getAdapter$p(this.this$0).getOnClickUserProfile();
        m.checkNotNullExpressionValue(view, "view");
        onClickUserProfile.invoke(view, ((FriendsListViewModel$Item$SuggestedFriend) this.$data).getSuggestion().getUser());
    }
}
