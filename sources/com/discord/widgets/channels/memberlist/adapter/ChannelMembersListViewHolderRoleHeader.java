package com.discord.widgets.channels.memberlist.adapter;

import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListViewHolderRoleHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderRoleHeader extends RecyclerView$ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderRoleHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter$Item$RoleHeader data) {
        m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        textView.setText(data.getRoleName() + " — " + data.getMemberCount());
        this.binding.f2259b.setRole(Long.valueOf(data.getRoleId()), data.getGuildId());
        ViewCompat.setAccessibilityDelegate(this.binding.c, new ChannelMembersListViewHolderRoleHeader$bind$1());
    }
}
