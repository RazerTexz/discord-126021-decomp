package com.discord.widgets.channels;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGroupInviteFriendsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriendsAdapter extends MGRecyclerAdapterSimple<WidgetGroupInviteFriends$Model$FriendItem> {
    private Function2<? super User, ? super Boolean, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriendsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function2 access$getListener$p(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter) {
        return widgetGroupInviteFriendsAdapter.listener;
    }

    public static final /* synthetic */ void access$setListener$p(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter, Function2 function2) {
        widgetGroupInviteFriendsAdapter.listener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<WidgetGroupInviteFriends$Model$FriendItem> data, Function2<? super User, ? super Boolean, Unit> friendChosenListener) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(friendChosenListener, "friendChosenListener");
        super.setData(data);
        this.listener = friendChosenListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem(this, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
