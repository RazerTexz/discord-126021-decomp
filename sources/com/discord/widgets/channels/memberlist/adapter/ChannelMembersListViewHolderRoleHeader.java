package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelMembersListViewHolderRoleHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderRoleHeader extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderRoleHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.f15856a);
        C12238m.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.RoleHeader data) {
        C12238m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f15858c;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        textView.setText(data.getRoleName() + " — " + data.getMemberCount());
        this.binding.f15857b.setRole(Long.valueOf(data.getRoleId()), data.getGuildId());
        ViewCompat.setAccessibilityDelegate(this.binding.f15858c, new AccessibilityDelegateCompat() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderRoleHeader.bind.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                C12238m.checkNotNullParameter(host, "host");
                C12238m.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setHeading(true);
            }
        });
    }
}
