package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelMembersListViewHolderMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onClicked;

    public ChannelMembersListViewHolderMember$bind$1(Function0 function0) {
        this.$onClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onClicked.invoke();
    }
}
