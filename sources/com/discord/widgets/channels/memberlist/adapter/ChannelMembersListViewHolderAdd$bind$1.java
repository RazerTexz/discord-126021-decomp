package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelMembersListViewHolderAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderAdd$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onClicked;

    public ChannelMembersListViewHolderAdd$bind$1(Function0 function0) {
        this.$onClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onClicked.invoke();
    }
}
