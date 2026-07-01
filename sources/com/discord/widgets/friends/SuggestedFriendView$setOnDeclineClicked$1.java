package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SuggestedFriendView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SuggestedFriendView$setOnDeclineClicked$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onDeclineClicked;

    public SuggestedFriendView$setOnDeclineClicked$1(Function0 function0) {
        this.$onDeclineClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onDeclineClicked.invoke();
    }
}
