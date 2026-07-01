package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ boolean $incomingFriendRequest;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter$UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2(WidgetFriendsAddUserAdapter$UserViewHolder widgetFriendsAddUserAdapter$UserViewHolder, long j, boolean z2) {
        this.this$0 = widgetFriendsAddUserAdapter$UserViewHolder;
        this.$userId = j;
        this.$incomingFriendRequest = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getDeclineHandler$p = WidgetFriendsAddUserAdapter.access$getDeclineHandler$p(WidgetFriendsAddUserAdapter$UserViewHolder.access$getAdapter$p(this.this$0));
        if (function2Access$getDeclineHandler$p != null) {
        }
    }
}
