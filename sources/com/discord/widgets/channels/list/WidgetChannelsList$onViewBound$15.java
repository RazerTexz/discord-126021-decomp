package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet$Companion;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$15 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsList this$0;

    public WidgetChannelsList$onViewBound$15(WidgetChannelsList widgetChannelsList) {
        this.this$0 = widgetChannelsList;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (!GroupInviteFriendsSheetFeatureFlag.Companion.getINSTANCE().isEnabled()) {
            WidgetGroupInviteFriends.Companion.launch(this.this$0.requireContext(), WidgetChannelsList.ANALYTICS_SOURCE);
            return;
        }
        GroupInviteFriendsSheet$Companion groupInviteFriendsSheet$Companion = GroupInviteFriendsSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        GroupInviteFriendsSheet$Companion.show$default(groupInviteFriendsSheet$Companion, parentFragmentManager, 0L, WidgetChannelsList.ANALYTICS_SOURCE, 2, null);
    }
}
