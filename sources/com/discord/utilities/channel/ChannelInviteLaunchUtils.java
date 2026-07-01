package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.WidgetGroupInviteFriends$Companion;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet$Companion;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelInviteLaunchUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelInviteLaunchUtils {
    public static final ChannelInviteLaunchUtils INSTANCE = new ChannelInviteLaunchUtils();

    private ChannelInviteLaunchUtils() {
    }

    public static /* synthetic */ void inviteToChannel$default(ChannelInviteLaunchUtils channelInviteLaunchUtils, Fragment fragment, Channel channel, String str, Long l, String str2, int i, Object obj) {
        channelInviteLaunchUtils.inviteToChannel(fragment, channel, str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str2);
    }

    public final void inviteToChannel(Fragment fragment, Channel channel, String source, Long eventId, String inviteStoreKey) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(source, "source");
        if (channel != null) {
            long id2 = channel.getId();
            if (channel.getGuildId() != 0) {
                WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion = WidgetGuildInviteShare.Companion;
                Context contextRequireContext = fragment.requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                WidgetGuildInviteShare$Companion.launch$default(widgetGuildInviteShare$Companion, contextRequireContext, childFragmentManager, channel.getGuildId(), Long.valueOf(id2), false, eventId, inviteStoreKey, source, 16, null);
                return;
            }
            if (GroupInviteFriendsSheetFeatureFlag.Companion.getINSTANCE().isEnabled()) {
                GroupInviteFriendsSheet$Companion groupInviteFriendsSheet$Companion = GroupInviteFriendsSheet.Companion;
                FragmentManager childFragmentManager2 = fragment.getChildFragmentManager();
                m.checkNotNullExpressionValue(childFragmentManager2, "fragment.childFragmentManager");
                groupInviteFriendsSheet$Companion.show(childFragmentManager2, id2, source);
                return;
            }
            WidgetGroupInviteFriends$Companion widgetGroupInviteFriends$Companion = WidgetGroupInviteFriends.Companion;
            Context contextRequireContext2 = fragment.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "fragment.requireContext()");
            widgetGroupInviteFriends$Companion.launch(contextRequireContext2, id2, source);
        }
    }
}
