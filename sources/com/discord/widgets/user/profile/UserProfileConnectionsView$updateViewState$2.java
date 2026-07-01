package com.discord.widgets.user.profile;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$updateViewState$2 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onMutualGuildsItemClick;

    public UserProfileConnectionsView$updateViewState$2(Function0 function0) {
        this.$onMutualGuildsItemClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onMutualGuildsItemClick.invoke();
    }
}
