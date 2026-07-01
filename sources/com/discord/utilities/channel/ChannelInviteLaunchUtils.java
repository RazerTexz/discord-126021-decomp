package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelInviteLaunchUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelInviteLaunchUtils {
    public static final ChannelInviteLaunchUtils INSTANCE = new ChannelInviteLaunchUtils();

    private ChannelInviteLaunchUtils() {
    }

    public final void inviteToChannel(Fragment fragment, Channel channel, String source, Long eventId, String inviteStoreKey) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(source, "source");
        if (channel != null) {
            long id2 = channel.getId();
            if (channel.getGuildId() != 0) {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = fragment.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                companion.launch(contextRequireContext, childFragmentManager, channel.getGuildId(), (16 & 8) != 0 ? null : Long.valueOf(id2), (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : eventId, (16 & 64) != 0 ? null : inviteStoreKey, source);
                return;
            }
            if (GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                GroupInviteFriendsSheet.Companion companion2 = GroupInviteFriendsSheet.INSTANCE;
                FragmentManager childFragmentManager2 = fragment.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager2, "fragment.childFragmentManager");
                companion2.show(childFragmentManager2, id2, source);
                return;
            }
            WidgetGroupInviteFriends.Companion companion3 = WidgetGroupInviteFriends.INSTANCE;
            Context contextRequireContext2 = fragment.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "fragment.requireContext()");
            companion3.launch(contextRequireContext2, id2, source);
        }
    }
}
