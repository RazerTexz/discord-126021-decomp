package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.User;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ User $user;
    public final /* synthetic */ WidgetFriendsAddUserAdapter$UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$3(WidgetFriendsAddUserAdapter$UserViewHolder widgetFriendsAddUserAdapter$UserViewHolder, User user) {
        this.this$0 = widgetFriendsAddUserAdapter$UserViewHolder;
        this.$user = user;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getSendHandler$p = WidgetFriendsAddUserAdapter.access$getSendHandler$p(WidgetFriendsAddUserAdapter$UserViewHolder.access$getAdapter$p(this.this$0));
        if (function2Access$getSendHandler$p != null) {
        }
    }
}
