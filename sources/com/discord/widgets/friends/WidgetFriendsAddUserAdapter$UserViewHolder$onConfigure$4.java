package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$4 implements View$OnClickListener {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter$UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$4(WidgetFriendsAddUserAdapter$UserViewHolder widgetFriendsAddUserAdapter$UserViewHolder, long j) {
        this.this$0 = widgetFriendsAddUserAdapter$UserViewHolder;
        this.$userId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsAddUserAdapter.access$getOnItemClick$p(WidgetFriendsAddUserAdapter$UserViewHolder.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$userId));
    }
}
