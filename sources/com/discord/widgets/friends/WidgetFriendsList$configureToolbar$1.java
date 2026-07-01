package com.discord.widgets.friends;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.R$id;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet$Companion;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics$Companion;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.contact_sync.WidgetContactSync$Companion;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$configureToolbar$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetFriendsList this$0;

    public WidgetFriendsList$configureToolbar$1(WidgetFriendsList widgetFriendsList) {
        this.this$0 = widgetFriendsList;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_friends_add_friend /* 2131364389 */:
                WidgetFriendsAdd$Companion widgetFriendsAdd$Companion = WidgetFriendsAdd.Companion;
                m.checkNotNullExpressionValue(context, "context");
                WidgetFriendsAdd$Companion.show$default(widgetFriendsAdd$Companion, context, null, "Friends", 2, null);
                break;
            case R$id.menu_friends_contact_sync /* 2131364390 */:
                ContactSyncFlowAnalytics$Companion.trackStart$default(ContactSyncFlowAnalytics.Companion, false, g0.mapOf(o.to("location_page", "Friends List Icon")), 1, null);
                AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits$Location("Friends List Icon", null, null, null, null, 30, null));
                WidgetContactSync$Companion widgetContactSync$Companion = WidgetContactSync.Companion;
                m.checkNotNullExpressionValue(context, "context");
                WidgetContactSync$Companion.launch$default(widgetContactSync$Companion, context, null, false, false, false, 30, null);
                break;
            case R$id.menu_friends_start_group /* 2131364391 */:
                if (!GroupInviteFriendsSheetFeatureFlag.Companion.getINSTANCE().isEnabled()) {
                    WidgetGroupInviteFriends.Companion.launch(this.this$0.requireContext(), "Friends");
                } else {
                    GroupInviteFriendsSheet$Companion groupInviteFriendsSheet$Companion = GroupInviteFriendsSheet.Companion;
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    GroupInviteFriendsSheet$Companion.show$default(groupInviteFriendsSheet$Companion, parentFragmentManager, 0L, "Friends", 2, null);
                }
                break;
        }
    }
}
