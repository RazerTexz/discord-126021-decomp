package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListViewHolderMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember$bind$3 implements View$OnClickListener {
    public final /* synthetic */ ChannelMembersListAdapter$Item$Member $data;
    public final /* synthetic */ boolean $isBooster;

    public ChannelMembersListViewHolderMember$bind$3(boolean z2, ChannelMembersListAdapter$Item$Member channelMembersListAdapter$Item$Member) {
        this.$isBooster = z2;
        this.$data = channelMembersListAdapter$Item$Member;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$isBooster) {
            String readableTimeString = TimeUtils.getReadableTimeString(a.x(view, "it", "it.context"), this.$data.getPremiumSince());
            Context context = view.getContext();
            Context context2 = view.getContext();
            m.checkNotNullExpressionValue(context2, "it.context");
            b.a.d.m.h(context, b.h(context2, 2131894155, new Object[]{readableTimeString}, null, 4), 0, null, 12);
        }
    }
}
