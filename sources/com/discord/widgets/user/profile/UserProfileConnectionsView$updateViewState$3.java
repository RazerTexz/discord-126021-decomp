package com.discord.widgets.user.profile;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$updateViewState$3 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onMutualFriendsItemClick;

    public UserProfileConnectionsView$updateViewState$3(Function0 function0) {
        this.$onMutualFriendsItemClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onMutualFriendsItemClick.invoke();
    }
}
