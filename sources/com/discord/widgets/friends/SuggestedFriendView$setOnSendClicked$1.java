package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SuggestedFriendView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SuggestedFriendView$setOnSendClicked$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onSendClicked;

    public SuggestedFriendView$setOnSendClicked$1(Function0 function0) {
        this.$onSendClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onSendClicked.invoke();
    }
}
