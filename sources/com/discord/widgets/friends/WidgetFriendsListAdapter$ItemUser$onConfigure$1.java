package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.User;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemUser$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ FriendsListViewModel$Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter$ItemUser this$0;

    public WidgetFriendsListAdapter$ItemUser$onConfigure$1(WidgetFriendsListAdapter$ItemUser widgetFriendsListAdapter$ItemUser, FriendsListViewModel$Item friendsListViewModel$Item) {
        this.this$0 = widgetFriendsListAdapter$ItemUser;
        this.$data = friendsListViewModel$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter$ItemUser.access$getAdapter$p(this.this$0).getOnClickUserProfile();
        m.checkNotNullExpressionValue(view, "view");
        onClickUserProfile.invoke(view, ((FriendsListViewModel$Item$Friend) this.$data).getUser());
    }
}
