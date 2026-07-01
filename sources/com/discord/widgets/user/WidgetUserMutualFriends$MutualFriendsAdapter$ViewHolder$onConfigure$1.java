package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserMutualFriends$Model$Item$MutualFriend $data;
    public final /* synthetic */ WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder this$0;

    public WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder$onConfigure$1(WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder widgetUserMutualFriends$MutualFriendsAdapter$ViewHolder, WidgetUserMutualFriends$Model$Item$MutualFriend widgetUserMutualFriends$Model$Item$MutualFriend) {
        this.this$0 = widgetUserMutualFriends$MutualFriendsAdapter$ViewHolder;
        this.$data = widgetUserMutualFriends$Model$Item$MutualFriend;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
        long id2 = this.$data.getUser().getId();
        FragmentManager parentFragmentManager = WidgetUserMutualFriends$MutualFriendsAdapter.access$getFragment$p(WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder.access$getAdapter$p(this.this$0)).getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "adapter.fragment.parentFragmentManager");
        WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
    }
}
