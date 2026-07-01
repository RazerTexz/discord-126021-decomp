package com.discord.widgets.channels.invite;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$Companion {
    private GroupInviteFriendsSheet$Companion() {
    }

    public static /* synthetic */ GroupInviteFriendsSheet show$default(GroupInviteFriendsSheet$Companion groupInviteFriendsSheet$Companion, FragmentManager fragmentManager, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            j = -1;
        }
        return groupInviteFriendsSheet$Companion.show(fragmentManager, j, str);
    }

    public final GroupInviteFriendsSheet show(FragmentManager fragmentManager, long channelId, String source) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(source, "source");
        GroupInviteFriendsSheet groupInviteFriendsSheet = new GroupInviteFriendsSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        if (channelId == -1) {
            AnalyticsTracker.openModal$default("DM Group Create", source, null, 4, null);
        } else {
            AnalyticsTracker.openModal$default("DM Group Add", source, null, 4, null);
        }
        groupInviteFriendsSheet.setArguments(bundleT);
        groupInviteFriendsSheet.show(fragmentManager, GroupInviteFriendsSheet.class.getSimpleName());
        return groupInviteFriendsSheet;
    }

    public /* synthetic */ GroupInviteFriendsSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
