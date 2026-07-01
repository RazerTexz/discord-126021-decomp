package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelMembersListViewHolderRoleHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderRoleHeader extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderRoleHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.RoleHeader data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        textView.setText(data.getRoleName() + " — " + data.getMemberCount());
        this.binding.f2259b.setRole(Long.valueOf(data.getRoleId()), data.getGuildId());
        ViewCompat.setAccessibilityDelegate(this.binding.c, new AccessibilityDelegateCompat() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderRoleHeader.bind.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Intrinsics3.checkNotNullParameter(host, "host");
                Intrinsics3.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setHeading(true);
            }
        });
    }
}
